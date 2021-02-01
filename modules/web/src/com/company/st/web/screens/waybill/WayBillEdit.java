package com.company.st.web.screens.waybill;

import com.company.st.entity.customer.Company;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.customer.Individual;
import com.company.st.web.screens.company.CompanyBrowse;
import com.haulmont.chile.core.model.MetaClass;
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

    @Subscribe("companyShipperLookup")
    public void onCompanyShipperLookupValueChange(HasValue.ValueChangeEvent<Customer> event) {
        Company company = (Company) event.getValue();
        shipperField.setValue(company);
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