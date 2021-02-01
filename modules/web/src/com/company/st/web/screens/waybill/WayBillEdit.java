package com.company.st.web.screens.waybill;

import com.company.st.entity.customer.Company;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.customer.Individual;
import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.company.st.entity.spaceport.SpacePort;
import com.company.st.web.screens.company.CompanyBrowse;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBill;

import javax.inject.Inject;

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

    @Subscribe("planetDeparturePicker")
    public void onPlanetDeparturePickerValueChange(HasValue.ValueChangeEvent<Planet> event) {
        Planet planet = event.getValue();
        SpacePort spacePort = dataManager.loadValue("select e from st_SpacePort e where e.is_default = :default and e.planet = :planet", SpacePort.class)
                .parameter("planet", planet)
                .parameter("default", true)
                .one();
        if (spacePort != null){
            departurePortField.setValue(spacePort);
        }  else {
            notifications.create(Notifications.NotificationType.SYSTEM).withCaption("У данной планеты не задан порт по умолчанию!").show();
        }
    }

    @Subscribe("moonDeparturePicker")
    public void onMoonDeparturePickerValueChange(HasValue.ValueChangeEvent<Moon> event) {
        Moon moon = event.getValue();
        SpacePort spacePort = dataManager.load(SpacePort.class).query("select e from st_SpacePort e where e.is_default = :default and e.moon = :moon")
                .parameter("default", true)
                .parameter("moon", moon)
                .one();
        if (spacePort != null){
            departurePortField.setValue(spacePort);
        } else {
            notifications.create(Notifications.NotificationType.SYSTEM).withCaption("У данного спутника не задан порт по умолчанию!").show();
        }
    }

    @Subscribe("planetDestinationPicker")
    public void onPlanetDestinationPickerValueChange(HasValue.ValueChangeEvent<Planet> event) {
        Planet planet = event.getValue();
        SpacePort spacePort = dataManager.loadValue("select e from st_SpacePort e where e.IS_DEFAULT = true and e.planet = :planet", SpacePort.class)
                .parameter("planet", planet)
                .one();
        if (spacePort != null){
            destinationPortField.setValue(spacePort);
        } else {
            notifications.create(Notifications.NotificationType.SYSTEM).withCaption("У данной планеты не задан порт по умолчанию!").show();
        }
    }

    @Subscribe("moonDestinationPicker")
    public void onMoonDestinationPickerValueChange(HasValue.ValueChangeEvent<Moon> event) {
        Moon moon = event.getValue();
        SpacePort spacePort = dataManager.loadValue("select e from st_SpacePort e where e.IS_DEFAULT = true and e.moon = :moon", SpacePort.class)
                .parameter("moon", moon)
                .one();
        if (spacePort != null){
            destinationPortField.setValue(spacePort);
        } else {
            notifications.create(Notifications.NotificationType.SYSTEM).withCaption("У данного спутника не задан порт по умолчанию!").show();
        }
    }

    @Subscribe("companyShipperLookup")
    public void onCompanyShipperLookupValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Company company = (Company) event.getValue();
        shipperField.setValue(company);
    }

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

    @Subscribe("individualShipperLookup")
    public void onIndividualShipperLookupValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Individual individual = (Individual) event.getValue();
        shipperField.setValue(individual);
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





}