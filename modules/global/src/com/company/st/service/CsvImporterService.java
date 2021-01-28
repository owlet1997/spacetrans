package com.company.st.service;

import java.io.File;
import java.io.FileDescriptor;

public interface CsvImporterService {
    String NAME = "st_CsvImporterService";

    String updatePlanetsFromFile(String filePath);
}