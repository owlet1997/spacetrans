package com.company.st.web.screens.planet;

import com.company.st.service.CsvImporterService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.RemoveOperation;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@UiController("st_Planet.browse")
@UiDescriptor("planet-browse.xml")
@LookupComponent("planetsTable")
@LoadDataBeforeShow
public class PlanetBrowse extends StandardLookup<Planet> {

    private static final Logger log = LoggerFactory.getLogger(PlanetBrowse.class);
    @Inject
    private GroupTable<Planet> planetsTable;
    @Inject
    private Image planetImage;
    @Inject
    private FileUploadField uploadFile;
    @Inject
    private Label<String> planetLabel;
    @Inject
    private CsvImporterService csvImporterService;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private Notifications notifications;

    @Subscribe("planetsTable")
    public void onPlanetsTableSelection(Table.SelectionEvent<Planet> event) {
        Planet selectedPlanet = null;
        try{
            selectedPlanet = Objects.requireNonNull(planetsTable.getSingleSelected());
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
        } catch (NullPointerException e){
            log.error("Planet was removed from list");
        }
    }

    @Subscribe("uploadFile")
    public void onUploadFileFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        File file = fileUploadingAPI.getFile(uploadFile.getFileId());
        String absolutePath = file.getAbsolutePath();
        log.info(absolutePath);

        String message = csvImporterService.updatePlanetsFromFile(file);
        notifications.create()
                .withCaption(message)
                .show();

        uploadFile.clear();

    }

}