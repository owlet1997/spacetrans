package com.company.st.web.screens.waybillitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBillItem;

@UiController("st_WayBillItem.browse")
@UiDescriptor("way-bill-item-browse.xml")
@LookupComponent("wayBillItemsTable")
@LoadDataBeforeShow
public class WayBillItemBrowse extends StandardLookup<WayBillItem> {
}