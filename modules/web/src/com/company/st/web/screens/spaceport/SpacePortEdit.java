package com.company.st.web.screens.spaceport;

import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spaceport.SpacePort;

import javax.inject.Inject;

@UiController("st_SpacePort.edit")
@UiDescriptor("space-port-edit.xml")
@EditedEntityContainer("spacePortDc")
@LoadDataBeforeShow
public class SpacePortEdit extends StandardEditor<SpacePort> {

    @Inject
    private PickerField<Moon> moonField;
    @Inject
    private PickerField<Planet> planetField;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;


}