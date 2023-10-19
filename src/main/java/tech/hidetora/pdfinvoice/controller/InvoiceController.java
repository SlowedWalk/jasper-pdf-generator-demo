package tech.hidetora.pdfinvoice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.hidetora.pdfinvoice.repository.UserRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {
    private final UserRepository userRepository;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generateReport() throws Exception {
        JRBeanCollectionDataSource jrBeanCollectionDataSource= new  JRBeanCollectionDataSource(userRepository.findAll());
        JasperReport compiledReport = JasperCompileManager.compileReport(new FileInputStream("src/resources/invoice.jrxml"));
        HashMap<String, Object> map = new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compiledReport, map, jrBeanCollectionDataSource);
//        JasperExportManager.exportReportToPdfFile(report, "invoice.pdf");
        byte[] data = JasperExportManager.exportReportToPdf(report, "invoice.pdf");

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=invoice.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }
}
