package com.company.st.web.screens.atmosphere;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.atmosphere.Atmosphere;

@UiController("st_Atmosphere.edit")
@UiDescriptor("atmosphere-edit.xml")
@EditedEntityContainer("atmosphereDc")
@LoadDataBeforeShow
public class AtmosphereEdit extends StandardEditor<Atmosphere> {
}