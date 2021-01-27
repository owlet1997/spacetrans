package com.company.st.web.screens.atmosphericgas;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.atmosphere.AtmosphericGas;

@UiController("st_AtmosphericGas.edit")
@UiDescriptor("atmospheric-gas-edit.xml")
@EditedEntityContainer("atmosphericGasDc")
@LoadDataBeforeShow
public class AtmosphericGasEdit extends StandardEditor<AtmosphericGas> {
}