package tech.hidetora.pdfinvoice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hidetora.pdfinvoice.entity.User;
import tech.hidetora.pdfinvoice.repository.UserRepository;
import tech.hidetora.pdfinvoice.service.UserService;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
@Slf4j
public class InvoiceController {
        private final UserService service;

        @GetMapping("/generate")
        public ResponseEntity<byte[]> generateReport() throws Exception {
            List<User> users = service.getAllUsers();
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new  JRBeanCollectionDataSource(users, false);
            JasperReport compiledReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/invoice.jrxml"));
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Title", "USER REPORT");
            parameters.put("ReportNum", "INV-"+UUID.randomUUID().toString().substring(0, 6));
            JasperPrint report = JasperFillManager.fillReport(compiledReport, parameters, jrBeanCollectionDataSource);
        //            JasperExportManager.exportReportToPdfFile(report, "invoice.pdf");
            byte[] data = JasperExportManager.exportReportToPdf(report);

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
        }
}
