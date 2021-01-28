package com.company.st.service;

import com.company.st.core.utils.CsvParserUtil;
import com.company.st.entity.spacebody.Planet;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.File;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Service(CsvImporterService.NAME)
public class CsvImporterServiceBean implements CsvImporterService {

    private static final Logger log = LoggerFactory.getLogger(CsvImporterServiceBean.class);
    @Inject
    private DataManager dataManager;

    @Override
    public String updatePlanetsFromFile(File file) {
        CsvParserUtil parser = new CsvParserUtil();

        try {
            List<String[]> list = parser.checkValidFile(file);
            if (list.isEmpty()){
                log.error("Incorrect file!");
                return "Incorrect file!";
            }
            StringBuilder builder = new StringBuilder();
            for (String[] str: list) {
                log.info(Arrays.toString(str));
                builder.append(checkPlanet(str)).append("\n");
            }
            return builder.toString();
        } catch (URISyntaxException | ParseException e) {
            log.error("Error", e);
            return "Error";
        }
    }

    public String checkPlanet(String[] arr) throws ParseException {
        Planet planet = null;

        try {
            planet = dataManager.loadValue("select s from st_Planet s where s.name = :name", Planet.class)
                    .parameter("name", arr[0]).one();
            updatePlanet(arr, planet);
            dataManager.commit(planet);
            return "Planet " + planet.getName() + " updated!";

        } catch (IllegalStateException e){
            Planet newPlanet = createPlanet(arr);
            dataManager.commit(newPlanet);
            return "Planet " + newPlanet.getName() + " added!";
        }
    }

    public Planet createPlanet(String[] arr) {
        Planet planet = dataManager.create(Planet.class);
        setPlanetTraits(arr, planet);
        log.info("Planet " + planet.getName() + " added!");
        log.info(planet.toString());
        return planet;
    }

    public void updatePlanet(String[] arr, Planet planet) {
        setPlanetTraits(arr, planet);
        log.info("Planet " + planet.getName() + " updated!");
        log.info(planet.toString());
    }

    private void setPlanetTraits(String[] arr, Planet planet){
        planet.setName(arr[0]);
        planet.setMass(Double.valueOf(arr[1]));
        planet.setSemiMajorAxes(Double.valueOf(arr[2]));
        planet.setOrbitalPeriod(Double.valueOf(arr[3]));
        planet.setRotationPeriod(Double.valueOf(arr[4]));
        boolean rings = arr[5].equals("yes");
        planet.setRings(rings);
    }
}