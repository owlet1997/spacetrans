package com.company.st.web.screens.waybill;

import com.company.st.entity.customer.Company;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.customer.Individual;
import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.company.st.entity.spaceport.Carrier;
import com.company.st.entity.spaceport.SpacePort;
import com.company.st.entity.waybill.WayBillItem;
import com.company.st.service.ChargeCountWaybillItemService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.RemoveOperation;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.ValueSource;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBill;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@UiController("st_WayBill.edit")
@UiDescriptor("way-bill-edit.xml")
@EditedEntityContainer("wayBillDc")
@LoadDataBeforeShow
public class WayBillEdit extends StandardEditor<WayBill> {

    @Inject
    private PickerField<Customer> shipperField;
    @Inject
    private CheckBox checkBoxCompanyShipper;
    @Inject
    private LookupField<Customer> companyShipperLookup;
    @Inject
    private LookupField<Customer> individualShipperLookup;
    @Inject
    private CheckBox checkBoxMoonDeparture;
    @Inject
    private CheckBox checkBoxMoonDestination;
    @Inject
    private PickerField<Moon> moonDeparturePicker;
    @Inject
    private PickerField<Planet> planetDeparturePicker;
    @Inject
    private PickerField<Planet> planetDestinationPicker;
    @Inject
    private PickerField<Moon> moonDestinationPicker;
    @Inject
    private PickerField<SpacePort> departurePortField;
    @Inject
    private PickerField<SpacePort> destinationPortField;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private InstanceContainer<WayBill> wayBillDc;
    @Inject
    private CollectionPropertyContainer<WayBillItem> itemsDc;
    @Inject
    private TextField<Double> totalChargeField;
    @Inject
    private TextField<Double> totalWeightField;
    @Inject
    private ChargeCountWaybillItemService chargeCountWaybillItemService;
    @Inject
    private Logger log;
    @Inject
    private PickerField<Customer> consigneeField;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    private LookupField<Carrier> carrierField;

    // автоматическое заполнение поля creator в создаваемой накладной
    @Subscribe
    public void onInitEntity(InitEntityEvent<WayBill> event) {
        WayBill wayBill = event.getEntity();
        wayBill.setCreator(userSessionSource.getUserSession().getUser());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    // динамическое изменение поля totalWeight после изменений в таблице WayBillItems
    // после добавления новой записи
    @Install(to = "itemsTable.create", subject = "afterCloseHandler")
    private void itemsTableCreateAfterCloseHandler(AfterCloseEvent afterCloseEvent) {
        try {
            double totalWeight = getTotalWeight();
            double totalCharge = chargeCountWaybillItemService.getTotalCharge(wayBillDc.getItem());

            totalWeightField.setValue(totalWeight);
            totalChargeField.setValue(totalCharge);
        } catch (NullPointerException e){
            notifications.create(Notifications.NotificationType.WARNING).withCaption("Список пуст!").show();
        }

    }

    // после изменения записи
    @Install(to = "itemsTable.edit", subject = "afterCloseHandler")
    private void itemsTableEditAfterCloseHandler(AfterCloseEvent afterCloseEvent) {
        double totalWeight = getTotalWeight();
        double totalCharge = chargeCountWaybillItemService.getTotalCharge(wayBillDc.getItem());

        totalWeightField.setValue(totalWeight);
        totalChargeField.setValue(totalCharge);
    }

    // после удаления записи
    @Install(to = "itemsTable.remove", subject = "afterActionPerformedHandler")
    private void itemsTableRemoveAfterActionPerformedHandler(RemoveOperation.AfterActionPerformedEvent<WayBillItem> afterActionPerformedEvent) {
        try {
            double totalWeight = getTotalWeight();
            double totalCharge = chargeCountWaybillItemService.getTotalCharge(wayBillDc.getItem());

            totalWeightField.setValue(totalWeight);
            totalChargeField.setValue(totalCharge);
        } catch (NullPointerException e){
            notifications.create(Notifications.NotificationType.WARNING).withCaption("Список пуст!").show();
        }
    }

    // установка значения порта по умолчанию     ////////////////////////////////////////////////////////////////////////////////////////////

    // установка значения порта по умолчанию у планеты-отправителя груза
    @Subscribe("planetDeparturePicker")
    public void onPlanetDeparturePickerValueChange(HasValue.ValueChangeEvent<Planet> event) {
        try{
            Planet planet = event.getValue();
            SpacePort spacePort = dataManager.loadValue("select e from st_SpacePort e where e.isDefault = :default and e.planet = :planet", SpacePort.class)
                .parameter("planet", planet)
                .parameter("default", true)
                .one();
            departurePortField.setValue(spacePort);
            } catch (IllegalStateException e){
                notifications.create(Notifications.NotificationType.WARNING).withCaption("У данной планеты не задан порт по умолчанию!").show();
            }
    }

    // установка значения порта по умолчанию у спутника-отправителя груза
    @Subscribe("moonDeparturePicker")
    public void onMoonDeparturePickerValueChange(HasValue.ValueChangeEvent<Moon> event) {
        try{
            Moon moon = event.getValue();
            SpacePort spacePort = dataManager.load(SpacePort.class).query("select e from st_SpacePort e where e.isDefault = :default and e.moon = :moon")
                    .parameter("default", true)
                    .parameter("moon", moon)
                    .one();
            departurePortField.setValue(spacePort);
        } catch (IllegalStateException e){
            notifications.create(Notifications.NotificationType.WARNING).withCaption("У данного спутника не задан порт по умолчанию!").show();
            if (!carrierField.isEmpty()) carrierField.clear();
        }

    }

    @Subscribe("destinationPortField")
    public void onDestinationPortFieldValueChange(HasValue.ValueChangeEvent<SpacePort> event) {
        if (!departurePortField.isEmpty() && !destinationPortField.isEmpty()){
            SpacePort spacePort1 = departurePortField.getValue();
            SpacePort spacePort2 = destinationPortField.getValue();
            List<Carrier> carrierList = dataManager.load(Carrier.class).query("select e from st_Carrier e").view("new-carrier-view").list();
            List<Carrier> filteredList = carrierList.stream().filter(e -> (e.getPorts().contains(spacePort1) && e.getPorts().contains(spacePort2))).collect(Collectors.toList());

            carrierField.setOptionsList(filteredList);
            if (filteredList.isEmpty()){
                notifications.create(Notifications.NotificationType.WARNING).withCaption("Ни один перевозчик не обслуживает оба порта!").show();
                if (!carrierField.isEmpty()) carrierField.clear();
            }
        }

    }

    @Subscribe("departurePortField")
    public void onDeparturePortFieldValueChange(HasValue.ValueChangeEvent<SpacePort> event) {
        if (!departurePortField.isEmpty() && !destinationPortField.isEmpty()){
            SpacePort spacePort1 = departurePortField.getValue();
            SpacePort spacePort2 = destinationPortField.getValue();
            List<Carrier> carrierList = dataManager.load(Carrier.class).query("select e from st_Carrier e").view("new-carrier-view").list();

            log.info(carrierList.toString());
            List<Carrier> filteredList = carrierList.stream().filter(e -> (e.getPorts().contains(spacePort1) && e.getPorts().contains(spacePort2))).collect(Collectors.toList());

            carrierField.setOptionsList(filteredList);
            if (filteredList.isEmpty()){
                notifications.create(Notifications.NotificationType.WARNING).withCaption("Ни один перевозчик не обслуживает оба порта!").show();
            }
        }
    }


    // установка значения порта по умолчанию у планеты-получателя груза
    @Subscribe("planetDestinationPicker")
    public void onPlanetDestinationPickerValueChange(HasValue.ValueChangeEvent<Planet> event) {
        try{
            Planet planet = event.getValue();
            SpacePort spacePort = dataManager.loadValue("select e from st_SpacePort e where e.isDefault = true and e.planet = :planet", SpacePort.class)
                    .parameter("planet", planet)
                    .one();
            destinationPortField.setValue(spacePort);

        } catch (IllegalStateException e){
            notifications.create(Notifications.NotificationType.WARNING).withCaption("У данной планеты не задан порт по умолчанию!").show();
        }
    }

    // установка значения порта по умолчанию у спутника-получателя груза
    @Subscribe("moonDestinationPicker")
    public void onMoonDestinationPickerValueChange(HasValue.ValueChangeEvent<Moon> event) {
        try{
            Moon moon = event.getValue();
            SpacePort spacePort = dataManager.loadValue("select e from st_SpacePort e where e.isDefault = true and e.moon = :moon", SpacePort.class)
                    .parameter("moon", moon)
                    .one();

            destinationPortField.setValue(spacePort);
        } catch (IllegalStateException e){
            notifications.create(Notifications.NotificationType.WARNING).withCaption("У данного спутника не задан порт по умолчанию!").show();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe("companyShipperLookup")
    public void onCompanyShipperLookupValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Customer company = event.getValue();
        log.info(company.toString());
        shipperField.setValue((Customer) company);
    }

    @Subscribe("individualShipperLookup")
    public void onIndividualShipperLookupValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Customer individual = event.getValue();
        log.info(individual.toString());
        shipperField.setValue((Customer) individual);
    }

    @Subscribe("checkBoxCompanyShipper")
    public void onCheckBoxCompanyShipperValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        if (checkBoxCompanyShipper.isChecked()){
            companyShipperLookup.setVisible(true);
            individualShipperLookup.setVisible(false);
        }
        if (!checkBoxCompanyShipper.isChecked()){
            companyShipperLookup.setVisible(false);
            individualShipperLookup.setVisible(true);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    @Inject
    private CheckBox checkBoxCompanyConsignee;
    @Inject
    private PickerField<Individual> individualConsigneePicker;
    @Inject
    private PickerField<Company> companyConsigneePicker;

    @Subscribe("checkBoxCompanyConsignee")
    public void onCheckBoxCompanyConsigneeValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        if (checkBoxCompanyConsignee.isChecked()){
            companyConsigneePicker.setVisible(true);
            individualConsigneePicker.setVisible(false);
        }
        if (!checkBoxCompanyConsignee.isChecked()){
            companyConsigneePicker.setVisible(false);
            individualConsigneePicker.setVisible(true);
        }
    }

    @Subscribe("individualConsigneePicker")
    public void onIndividualConsigneePickerValueChange(HasValue.ValueChangeEvent<Individual> event) {
        Customer customer = event.getValue();
        consigneeField.setValue(customer);
    }

    @Subscribe("companyConsigneePicker")
    public void onCompanyConsigneePickerValueChange(HasValue.ValueChangeEvent<Company> event) {
        Customer customer = event.getValue();
        consigneeField.setValue(customer);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    @Subscribe("checkBoxMoonDeparture")
    public void onCheckBoxMoonDepartureValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        if (checkBoxMoonDeparture.isChecked()){
            planetDeparturePicker.setVisible(false);
            moonDeparturePicker.setVisible(true);
        }
        if (!checkBoxMoonDeparture.isChecked()){
            planetDeparturePicker.setVisible(true);
            moonDeparturePicker.setVisible(false);
        }
    }


    @Subscribe("checkBoxMoonDestination")
    public void onCheckBoxMoonDestinationValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        if (checkBoxMoonDestination.isChecked()){
            planetDestinationPicker.setVisible(false);
            moonDestinationPicker.setVisible(true);
        }
        if (!checkBoxMoonDestination.isChecked()){
            planetDestinationPicker.setVisible(true);
            moonDestinationPicker.setVisible(false);
        }
    }

    private double getTotalWeight(){
        double totalWeight = 0;
        List<WayBillItem> wayBillItems = itemsDc.getItems();
        if (!wayBillItems.isEmpty()) {
            for (WayBillItem e: wayBillItems) {
                totalWeight += e.getWeight();
            }
        }
        return totalWeight;
    }





}