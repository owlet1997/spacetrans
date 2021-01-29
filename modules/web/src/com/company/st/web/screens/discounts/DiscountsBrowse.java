package com.company.st.web.screens.discounts;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Discounts;

@UiController("st_Discounts.browse")
@UiDescriptor("discounts-browse.xml")
@LookupComponent("discountsesTable")
@LoadDataBeforeShow
public class DiscountsBrowse extends StandardLookup<Discounts> {
}