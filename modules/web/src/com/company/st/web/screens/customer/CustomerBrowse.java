package com.company.st.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Customer;

@UiController("st_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}