package com.company.st.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Company;

@UiController("st_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}