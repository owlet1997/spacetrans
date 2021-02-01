package com.company.st.web.screens.carrier;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spaceport.Carrier;

@UiController("st_Carrier.browse")
@UiDescriptor("carrier-browse.xml")
@LookupComponent("carriersTable")
@LoadDataBeforeShow
public class CarrierBrowse extends StandardLookup<Carrier> {
}