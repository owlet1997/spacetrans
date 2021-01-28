package com.company.st.core.utils;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class CsvParserUtil {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CsvParserUtil.class);
    private final String[] columns =
                {"name","mass","semiMajorAxes","orbitalPeriod","rotationPeriod","rings"};


    public List<String[]> checkValidFile(File file) throws URISyntaxException {

        List<String[]> r = null;

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            r = reader.readAll();
        } catch (IOException | CsvException e) {
            log.error("Error", e);
        }
        assert r != null;
        if (Arrays.equals(r.get(0), columns)){
            log.info("File is correct");
            r.remove(0);
            return r;
        } else {
            return null;
        }
    }


        private List<String[]> getStringsFromFile(){
            return null;
        }
}
