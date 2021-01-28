package com.company.st.service;

import com.company.st.core.utils.CsvParserUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Service(CsvImporterService.NAME)
public class CsvImporterServiceBean implements CsvImporterService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CsvImporterServiceBean.class);

    @Override
    public void updatePlanetsFromFile(File file) {
        CsvParserUtil parser = new CsvParserUtil();
        try {
            List<String[]> list = parser.checkValidFile(file);
            for (String[] str: list) {
                log.info(Arrays.toString(str));
            }
        } catch (URISyntaxException e) {
            log.error("Error", e);
        }
    }
}