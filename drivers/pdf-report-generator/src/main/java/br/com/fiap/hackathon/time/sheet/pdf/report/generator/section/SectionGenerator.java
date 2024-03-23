package br.com.fiap.hackathon.time.sheet.pdf.report.generator.section;

import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public interface SectionGenerator {
    void generate(XWPFDocument document, TimesheetReportDTO dto);
}
