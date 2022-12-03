package com.starsky.service.impl;

import com.starsky.service.JasperService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JsonDataSource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@Slf4j
@Component
public class JasperServiceImpl implements JasperService {

    @Override
    public void exportReportToPdfStream(InputStream inputStream, OutputStream outputStream, JsonDataSource jsonDataSource, Map<String, Object> params) {

        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(inputStream, params, jsonDataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            log.error("JasperFill or export error, ", e);
        }
    }

    @Override
    public byte[] exportReportToPdf(InputStream inputStream, JsonDataSource jsonDataSource, Map<String, Object> params) {
        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(inputStream, params, jsonDataSource);
            JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            log.error("JasperFill or export error, ", e);
        }
        return new byte[0];
    }
}
