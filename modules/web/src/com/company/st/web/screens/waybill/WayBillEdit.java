package com.company.st.web.screens.waybill;

import com.company.st.entity.customer.Company;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.customer.Individual;
import com.company.st.web.screens.company.CompanyBrowse;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBill;

import javax.inject.Inject;

@UiController("st_WayBill.edit")
@UiDescriptor("way-bill-edit.xml")
@EditedEntityContainer("wayBillDc")
@LoadDataBeforeShow
public class WayBillEdit extends StandardEditor<WayBill> {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private PickerField<Customer> shipperField;
    @Inject
    private CheckBox checkBoxCompanyShipper;
    @Inject
    private PickerField<Individual> individualShipperPicker;
    @Inject
    private PickerField<Company> companyShipperPicker;

    @Subscribe("companyShipperPicker")
    public void onCompanyShipperPickerValueChange(HasValue.ValueChangeEvent<Company> event) {
        Company company = event.getValue();
        shipperField.setValue(company);
    }

    @Subscribe("individualShipperPicker")
    public void onIndividualShipperPickerValueChange(HasValue.ValueChangeEvent<Individual> event) {
        Individual individual = event.getValue();
        shipperField.setValue(individual);
    }

    @Subscribe("checkBoxCompanyShipper")
    public void onCheckBoxCompanyShipperValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        if (checkBoxCompanyShipper.isChecked()){
            companyShipperPicker.setVisible(true);
            individualShipperPicker.setVisible(false);
        }
        if (!checkBoxCompanyShipper.isChecked()){
            companyShipperPicker.setVisible(false);
            individualShipperPicker.setVisible(true);
        }
    }




}