package com.company.st.web.screens.waybill;

import com.company.st.entity.customer.Company;
import com.company.st.entity.customer.Customer;
import com.company.st.entity.customer.Individual;
import com.company.st.web.screens.company.CompanyBrowse;
import com.company.st.web.screens.individual.IndividualBrowse;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBill;

import javax.inject.Inject;

@UiController("st_WayBill.edit")
@UiDescriptor("way-bill-edit.xml")
@EditedEntityContainer("wayBillDc")
@LoadDataBeforeShow
public class WayBillEdit extends StandardEditor<WayBill> {
    @Inject
    private CheckBox consigneeFieldCheckBox;
    @Inject
    private InstanceContainer<WayBill> wayBillDc;
    @Inject
    private InstanceContainer<Company> shipperDC;

    @Inject
    private LookupScreenFacet<Company, CompanyBrowse> lookupCompanyScreen;
    @Inject
    private LookupScreenFacet<Individual, IndividualBrowse> lookupIndividualScreen;
    @Inject
    private PickerField<Customer> consigneeField;

//    @Subscribe("consigneeField.lookup")
//    public void onConsigneeFieldLookup(Action.ActionPerformedEvent event) {
//        if (consigneeFieldCheckBox.isChecked()){
//            consigneeField.
//
//        }
//        else if (!consigneeFieldCheckBox.isChecked()){
//            lookupIndividualScreen.show();
//        }
//    }
}