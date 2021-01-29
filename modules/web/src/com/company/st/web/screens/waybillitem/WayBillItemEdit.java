package com.company.st.web.screens.waybillitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBillItem;

@UiController("st_WayBillItem.edit")
@UiDescriptor("way-bill-item-edit.xml")
@EditedEntityContainer("wayBillItemDc")
@LoadDataBeforeShow
public class WayBillItemEdit extends StandardEditor<WayBillItem> {
}