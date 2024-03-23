package br.com.fiap.hackathon.time.sheet.pdf.report.generator.section;

import br.com.fiap.hackathon.time.sheet.pdf.report.generator.line.LineBuilderFactory;
import br.com.fiap.hackathon.time.sheet.pdf.report.generator.model.LineType;
import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import static br.com.fiap.hackathon.time.sheet.pdf.report.generator.util.DurationUtil.durationToSimpleString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HeaderSectionGenerator implements SectionGenerator {

    public static SectionGeneratorFactory.Builder builder() {
        return HeaderSectionGenerator::new;
    }

    @Override
    public void generate(XWPFDocument document, TimesheetReportDTO dto) {
        makeLine(document).setText(String.format("ID do Funcionário: %s", dto.getEmployeeId()));
        makeLine(document).setText(String.format("Mês/Ano: %s", dto.getYearMonth()));
        makeLine(document).setText(String.format("Total de horas trabalhadas: %s", durationToSimpleString(dto.getTotalWorkedHours())));
        makeLine(document).setText("");
    }

    private XWPFRun makeLine(XWPFDocument document) {
        return LineBuilderFactory.get(LineType.DETAIL).build(document);
    }
}
