package com.company.st.web.screens.carrier;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spaceport.Carrier;

@UiController("st_Carrier.edit")
@UiDescriptor("carrier-edit.xml")
@EditedEntityContainer("carrierDc")
@LoadDataBeforeShow
public class CarrierEdit extends StandardEditor<Carrier> {
}