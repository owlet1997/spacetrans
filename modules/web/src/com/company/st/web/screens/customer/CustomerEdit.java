package com.company.st.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Customer;

@UiController("st_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}