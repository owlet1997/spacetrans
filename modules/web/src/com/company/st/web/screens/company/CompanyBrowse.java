package com.company.st.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Company;

@UiController("st_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("companiesTable")
@LoadDataBeforeShow
public class CompanyBrowse extends StandardLookup<Company> {
}