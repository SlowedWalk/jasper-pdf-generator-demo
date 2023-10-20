package tech.hidetora.pdfinvoice.service;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.hidetora.pdfinvoice.dto.InvoiceData;

import java.io.FileNotFoundException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PdfInvoiceService {
    public void generatePdfInvoice(InvoiceData request) throws FileNotFoundException {
        String path = "invoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);
        document.add(new Paragraph("TEST INVOICE"));

    }
}
