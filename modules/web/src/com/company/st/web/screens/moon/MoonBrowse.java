package com.company.st.web.screens.moon;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spacebody.Moon;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Objects;

@UiController("st_Moon.browse")
@UiDescriptor("moon-browse.xml")
@LookupComponent("moonsTable")
@LoadDataBeforeShow
public class MoonBrowse extends StandardLookup<Moon> {
    @Inject
    private GroupTable<Moon> moonsTable;
    @Inject
    private Image moonImage;

    @Subscribe("moonsTable")
    public void onMoonsTableSelection(Table.SelectionEvent<Moon> event) {

        Moon selectedMoon = moonsTable.getSingleSelected();
        FileDescriptor imageFile = Objects.requireNonNull(selectedMoon).getPicture();
        moonImage.setSource(FileDescriptorResource.class).setFileDescriptor(imageFile);

    }


}