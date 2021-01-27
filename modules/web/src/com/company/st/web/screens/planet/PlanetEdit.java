package com.company.st.web.screens.planet;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spacebody.Planet;

@UiController("st_Planet.edit")
@UiDescriptor("planet-edit.xml")
@EditedEntityContainer("planetDc")
@LoadDataBeforeShow
public class PlanetEdit extends StandardEditor<Planet> {
}