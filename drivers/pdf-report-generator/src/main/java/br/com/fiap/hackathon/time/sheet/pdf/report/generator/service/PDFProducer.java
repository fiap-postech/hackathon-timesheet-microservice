package br.com.fiap.hackathon.time.sheet.pdf.report.generator.service;

import br.com.fiap.hackathon.time.sheet.pdf.report.generator.exception.FailCreatingPDFException;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import lombok.NoArgsConstructor;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@NoArgsConstructor(staticName = "get")
public class PDFProducer {

    public byte[] produce(XWPFDocument document) {
        try (var output = new ByteArrayOutputStream()) {
            writeToPDF(document, output);

            return output.toByteArray();
        } catch (Exception e) {
            throw new FailCreatingPDFException(e);
        }
    }

    private void writeToPDF(XWPFDocument document, ByteArrayOutputStream output) throws IOException {
        ZipSecureFile.setMinInflateRatio(0);

        try (var out = new ByteArrayOutputStream()){
            document.write(out);

            try(var doc = new XWPFDocument(new ByteArrayInputStream(out.toByteArray()))) {
                var options = PdfOptions.create();

                PdfConverter.getInstance().convert(
                        doc,
                        output,
                        options
                );
            }
        }
    }

}
