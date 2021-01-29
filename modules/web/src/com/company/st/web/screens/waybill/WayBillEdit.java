package com.company.st.web.screens.waybill;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.waybill.WayBill;

@UiController("st_WayBill.edit")
@UiDescriptor("way-bill-edit.xml")
@EditedEntityContainer("wayBillDc")
@LoadDataBeforeShow
public class WayBillEdit extends StandardEditor<WayBill> {
}