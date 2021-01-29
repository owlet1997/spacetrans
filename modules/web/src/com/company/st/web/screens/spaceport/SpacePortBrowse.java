package com.company.st.web.screens.spaceport;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spaceport.SpacePort;

@UiController("st_SpacePort.browse")
@UiDescriptor("space-port-browse.xml")
@LookupComponent("spacePortsTable")
@LoadDataBeforeShow
public class SpacePortBrowse extends StandardLookup<SpacePort> {
}