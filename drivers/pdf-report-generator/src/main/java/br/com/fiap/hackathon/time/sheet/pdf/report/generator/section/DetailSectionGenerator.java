package br.com.fiap.hackathon.time.sheet.pdf.report.generator.section;

import br.com.fiap.hackathon.time.sheet.pdf.report.generator.line.LineBuilderFactory;
import br.com.fiap.hackathon.time.sheet.pdf.report.generator.model.LineType;
import br.com.fiap.tech.challenge.application.dto.TimeTrackingReportDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import static br.com.fiap.hackathon.time.sheet.pdf.report.generator.util.DurationUtil.durationToSimpleString;
import static java.util.stream.Collectors.groupingBy;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DetailSectionGenerator implements SectionGenerator {

    public static SectionGeneratorFactory.Builder builder() {
        return DetailSectionGenerator::new;
    }

    @Override
    public void generate(XWPFDocument document, TimesheetReportDTO dto) {
        var map = dto.getTimesheet().stream()
                .collect(groupingBy(TimeTrackingReportDTO::getDate));

        map.keySet().stream()
                .sorted()
                .forEach(key -> makeDay(document, key, map.get(key)));
    }

    private void makeDay(XWPFDocument document, LocalDate date, List<TimeTrackingReportDTO> items) {
        LineBuilderFactory.get(LineType.DETAIL).build(document).setText(date.toString());

        var table = document.createTable(items.size() + 1, 4);

        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(2L * 1440));
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(2L * 1440));
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(2L * 1440));
        table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(2L * 1440));

        table.setWidth(7 * 1440);

        makeHeader(table);

        var count = 1;

        for (var item : items) {
            makeDetail(table, count, item);
            count++;
        }

        document.createParagraph();
    }

    private void makeHeader(XWPFTable table) {
        var row = table.getRow(0);

        row.setHeight(1440 / 2);

        prepare(row, 0).setText("Horário da Entrada");
        prepare(row, 1).setText("Horário da Saída");
        prepare(row, 2).setText("Horas Trabalhadas");
        prepare(row, 3).setText("Observações");

    }

    private XWPFTableCell prepare(XWPFTableRow row, int cellNumber) {
        var cell = row.getCell(cellNumber);

        var table0With = cell.getCTTc().addNewTcPr().addNewTcW();
        table0With.setW(2 * 1440);
        table0With.setType(STTblWidth.DXA);

        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);

        var p = cell.getParagraphArray(0);
        p.setFontAlignment(ParagraphAlignment.CENTER.getValue());
        p.setSpacingBetween(12, LineSpacingRule.AT_LEAST);

        return cell;
    }

    private void makeDetail(XWPFTable table, int lineNumber, TimeTrackingReportDTO item) {
        var row = table.getRow(lineNumber);
        row.setHeight(600);

        prepare(row, 0).setText(item.getStartTimestamp().toString());
        prepare(row, 1).setText(String.valueOf(defaultIfNull(item.getEndTimestamp(), "")));
        prepare(row, 2).setText(durationToSimpleString(item.getTotalWorkedHours()));
        prepare(row, 3).setText(item.isConsistent() ? "---" : "LANÇAMENTO INCONSISTENTE");
    }
}
