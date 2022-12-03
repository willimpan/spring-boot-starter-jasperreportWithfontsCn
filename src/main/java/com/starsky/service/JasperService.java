package com.starsky.service;


import net.sf.jasperreports.engine.data.JsonDataSource;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public interface JasperService {

    void exportReportToPdfStream(InputStream inputStream, OutputStream outputStream, JsonDataSource jsonDataSource, Map<String, Object> params);


    default void exportReportToPdfStream(InputStream inputStream, OutputStream outputStream, JsonDataSource jsonDataSource) {
        exportReportToPdfStream(inputStream, outputStream, jsonDataSource, new HashMap<>());
    }


    byte[] exportReportToPdf(InputStream inputStream, JsonDataSource jsonDataSource, Map<String, Object> params);
}
