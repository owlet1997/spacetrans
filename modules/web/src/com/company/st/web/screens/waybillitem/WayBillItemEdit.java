package com.company.st.web.screens.waybillitem;

import com.company.st.service.ChargeCountWaybillItemService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBillItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@UiController("st_WayBillItem.edit")
@UiDescriptor("way-bill-item-edit.xml")
@EditedEntityContainer("wayBillItemDc")
@LoadDataBeforeShow
public class WayBillItemEdit extends StandardEditor<WayBillItem> {
    private static final Logger log = LoggerFactory.getLogger(WayBillItemEdit.class);
    @Inject
    private TextField<BigDecimal> chargeField;
    @Inject
    private ChargeCountWaybillItemService chargeCountWaybillItemService;

    @Inject
    private TextField<Double> dimHeightField;
    @Inject
    private TextField<Double> weightField;
    @Inject
    private TextField<Double> dimWidthField;
    @Inject
    private TextField<Double> dimLengthField;
    @Inject
    private TextField<Integer> numberField;

    @Inject
    private DataManager dataManager;
    @Inject
    private TextField<String> nameField;
    @Inject
    private Notifications notifications;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        try{
            WayBillItem wayBillItem = dataManager.load(WayBillItem.class)
                    .query("select c from st_WayBillItem c where c.name = :name")
                    .parameter("name", nameField.getValue())
                    .one();

            event.preventCommit();
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Элемент накладной с таким именем уже существует!").show();
        } catch (IllegalStateException e){
            Optional<List<WayBillItem>> list = Optional.ofNullable(getEditedEntity().getWayBill().getItems());
            if (list.isPresent()){
                Optional<WayBillItem> item = list.get().stream().filter(s -> s.getName().equals(nameField.getValue())).findFirst();
                if (item.isPresent()){
                    event.preventCommit();
                    notifications.create(Notifications.NotificationType.ERROR).withCaption("Элемент накладной с таким именем уже существует!").show();
                } else {
                    notifications.create().withCaption("Элемент накладной успешно добавлен!").show();
                }
            }


        }
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<WayBillItem> event) {
        double[] arr = getArray();
        chargeField.setValue(BigDecimal.valueOf(chargeCountWaybillItemService.getChargeValue(arr)));
    }



    @Subscribe("nameField")
    public void onNameFieldTextChange(TextInputField.TextChangeEvent event) {
        if (getEditedEntity().getWayBill().getItems() == null){
            getEditedEntity().setNumber(1);
            numberField.setValue(getEditedEntity().getNumber());
        } else {
            int number = getEditedEntity().getWayBill().getItems().size();
            getEditedEntity().setNumber(number + 1);
            numberField.setValue(getEditedEntity().getNumber());
        }
    }

    @Subscribe("dimWidthField")
    public void onDimWidthFieldValueChange(HasValue.ValueChangeEvent<Double> event) {
        double[] arr = getArray();
        chargeField.setValue(BigDecimal.valueOf(chargeCountWaybillItemService.getChargeValue(arr)));
    }

    @Subscribe("dimHeightField")
    public void onDimHeightFieldValueChange(HasValue.ValueChangeEvent<Double> event) {
        double[] arr = getArray();
        chargeField.setValue(BigDecimal.valueOf(chargeCountWaybillItemService.getChargeValue(arr)));

    }

    @Subscribe("weightField")
    public void onWeightFieldValueChange(HasValue.ValueChangeEvent<Double> event) {
        double[] arr = getArray();
        chargeField.setValue(BigDecimal.valueOf(chargeCountWaybillItemService.getChargeValue(arr)));

    }

    @Subscribe("dimLengthField")
    public void onDimLengthFieldValueChange(HasValue.ValueChangeEvent<Double> event) {
        double[] arr = getArray();
        chargeField.setValue(BigDecimal.valueOf(chargeCountWaybillItemService.getChargeValue(arr)));

    }

    private double[] getArray(){
        double height = dimHeightField.getValue() == null ? 1 : dimHeightField.getValue();
        double width = dimWidthField.getValue() == null ? 1 : dimWidthField.getValue();
        double length = dimLengthField.getValue() == null ? 1 : dimLengthField.getValue();
        double weight = weightField.getValue() == null ? 1 : weightField.getValue();
        return new double[]{height, width, length, weight};
    }


}