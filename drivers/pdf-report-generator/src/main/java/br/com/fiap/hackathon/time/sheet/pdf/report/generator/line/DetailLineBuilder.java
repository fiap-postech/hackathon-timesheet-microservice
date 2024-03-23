package br.com.fiap.hackathon.time.sheet.pdf.report.generator.line;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DetailLineBuilder implements LineBuilder {

    public static LineBuilderFactory.Builder builder() {
        return DetailLineBuilder::new;
    }

    @Override
    public XWPFRun build(XWPFDocument document) {
        var paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        paragraph.setSpacingBetween(14, LineSpacingRule.AT_LEAST);

        var run = paragraph.createRun();
        run.setFontSize(12);
        run.setFontFamily("Arial");

        return run;
    }
}
