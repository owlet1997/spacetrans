package com.company.st.web.screens.moon;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spacebody.Moon;

@UiController("st_Moon.edit")
@UiDescriptor("moon-edit.xml")
@EditedEntityContainer("moonDc")
@LoadDataBeforeShow
public class MoonEdit extends StandardEditor<Moon> {
}