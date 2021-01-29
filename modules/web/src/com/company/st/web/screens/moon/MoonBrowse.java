package com.company.st.web.screens.moon;

import com.company.st.entity.spacebody.Planet;
import com.company.st.web.screens.planet.PlanetBrowse;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spacebody.Moon;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Objects;

@UiController("st_Moon.browse")
@UiDescriptor("moon-browse.xml")
@LookupComponent("moonsTable")
@LoadDataBeforeShow
public class MoonBrowse extends StandardLookup<Moon> {
    private static final Logger log = LoggerFactory.getLogger(MoonBrowse.class);

    @Inject
    private GroupTable<Moon> moonsTable;
    @Inject
    private Image moonImage;
    @Inject
    private Label<String> moonLabel;

    @Subscribe("moonsTable")
    public void onMoonsTableSelection(Table.SelectionEvent<Moon> event) {

        Moon moon = null;
        try{
            moon = Objects.requireNonNull(moonsTable.getSingleSelected());
            if (moon.getPicture() != null){
                FileDescriptor imagefile = moon.getPicture();
                moonLabel.setVisible(false);
                moonImage.setVisible(true);
                moonImage.setSource(FileDescriptorResource.class).setFileDescriptor(imagefile);
            } else {
                moonImage.setVisible(false);
                moonLabel.setVisible(true);
                moonLabel.setValue("У выбранного спутника еще нет фотографии!");
            }
        } catch (NullPointerException e){
            log.error("Moon was removed from list");
        }
    }


}