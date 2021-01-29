package com.company.st.web.screens.discounts;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.customer.Discounts;

@UiController("st_Discounts.edit")
@UiDescriptor("discounts-edit.xml")
@EditedEntityContainer("discountsDc")
@LoadDataBeforeShow
public class DiscountsEdit extends StandardEditor<Discounts> {
}