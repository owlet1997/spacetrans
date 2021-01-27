package com.company.st.web.screens.gas;

import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.atmosphere.Gas;

@UiController("st_Gas.edit")
@UiDescriptor("gas-edit.xml")
@EditedEntityContainer("gasDc")
@LoadDataBeforeShow
public class GasEdit extends StandardEditor<Gas> {
}