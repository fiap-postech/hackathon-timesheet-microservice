package br.com.fiap.hackathon.time.sheet.pdf.report.generator.service;

import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import br.com.fiap.hackathon.time.sheet.pdf.report.generator.model.PageSize;
import br.com.fiap.hackathon.adapter.repository.TimeSheetReportGeneratorRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import static br.com.fiap.hackathon.time.sheet.pdf.report.generator.section.SectionGeneratorFactory.getSections;
import static br.com.fiap.hackathon.time.sheet.pdf.report.generator.util.PageSizes.currentPageSize;
import static br.com.fiap.hackathon.time.sheet.pdf.report.generator.util.Sections.currentSection;

@Service
@RequiredArgsConstructor
public class PDFReportService implements TimeSheetReportGeneratorRepository {

    private static final String PAGE_SIZE_KEY = "pdf.report.generator.config.page.size";
    private static final String PAGE_SIZE_DEFAULT = "A4";

    public byte[] generate(TimesheetReportDTO dto) {
        var document = createDocument();

        getSections().forEach(
                s -> s.generate(document, dto)
        );

        return PDFProducer.get().produce(document);
    }

    private XWPFDocument createDocument() {
        var document = new XWPFDocument();
        document.createStyles();
        document.createHeader(HeaderFooterType.DEFAULT);
        document.createFooter(HeaderFooterType.DEFAULT);

        var paper = System.getProperty(PAGE_SIZE_KEY, PAGE_SIZE_DEFAULT);

        var pageSize = PageSize.valueOf(paper);

        pageSize.configure(currentPageSize(currentSection(document)), true);

        return document;
    }

}
