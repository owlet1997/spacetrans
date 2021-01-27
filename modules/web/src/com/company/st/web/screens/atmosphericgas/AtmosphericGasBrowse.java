package com.company.st.web.screens.atmosphericgas;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.atmosphere.AtmosphericGas;

@UiController("st_AtmosphericGas.browse")
@UiDescriptor("atmospheric-gas-browse.xml")
@LookupComponent("atmosphericGasesTable")
@LoadDataBeforeShow
public class AtmosphericGasBrowse extends StandardLookup<AtmosphericGas> {
}