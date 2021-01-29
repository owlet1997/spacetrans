package com.company.st.web.screens.spaceport;

import com.company.st.entity.spacebody.Moon;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.RemoteException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.WindowManagerProvider;
import com.haulmont.cuba.gui.actions.picker.ClearAction;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.exception.EntityAccessExceptionHandler;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spaceport.SpacePort;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@UiController("st_SpacePort.edit")
@UiDescriptor("space-port-edit.xml")
@EditedEntityContainer("spacePortDc")
@LoadDataBeforeShow
public class SpacePortEdit extends StandardEditor<SpacePort> {

    @Inject
    private Notifications notifications;

    @Inject
    private PickerField<Planet> planetField;

    @Inject
    private PickerField<Moon> moonField;


    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (!moonField.isEmpty() && !planetField.isEmpty()){
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Место расположения порта может быть лишь одно").show();
            event.preventCommit();
        }
        if (moonField.isEmpty() && planetField.isEmpty()){
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Не выбрано место расположения порта").show();
            event.preventCommit();
        }
    }

}