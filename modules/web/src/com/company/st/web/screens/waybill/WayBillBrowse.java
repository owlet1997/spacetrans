package com.company.st.web.screens.waybill;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBill;

@UiController("st_WayBill.browse")
@UiDescriptor("way-bill-browse.xml")
@LookupComponent("wayBillsTable")
@LoadDataBeforeShow
public class WayBillBrowse extends StandardLookup<WayBill> {
}