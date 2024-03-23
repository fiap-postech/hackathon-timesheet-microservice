package br.com.fiap.hackathon.time.sheet.pdf.report.generator.line;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public interface LineBuilder {
    XWPFRun build(XWPFDocument document);
}
