package com.company.st.web.screens.planet;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Objects;

@UiController("st_Planet.browse")
@UiDescriptor("planet-browse.xml")
@LookupComponent("planetsTable")
@LoadDataBeforeShow
public class PlanetBrowse extends StandardLookup<Planet> {

    @Inject
    private GroupTable<Planet> planetsTable;
    @Inject
    private Image planetImage;
    @Inject
    private Label<String> planetLabel;

    @Subscribe("planetsTable")
    public void onPlanetsTableSelection(Table.SelectionEvent<Planet> event) {
        Planet selectedPlanet = Objects.requireNonNull(planetsTable.getSingleSelected());
        if (selectedPlanet.getPicture() != null){
            FileDescriptor imagefile = selectedPlanet.getPicture();
            planetLabel.setVisible(false);
            planetImage.setVisible(true);
            planetImage.setSource(FileDescriptorResource.class).setFileDescriptor(imagefile);
        } else {
            planetImage.setVisible(false);
            planetLabel.setVisible(true);
            planetLabel.setValue("У выбранной планеты еще нет фотографии!");
        }


    }
}