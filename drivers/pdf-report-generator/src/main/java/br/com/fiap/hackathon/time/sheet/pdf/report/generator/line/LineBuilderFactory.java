package br.com.fiap.hackathon.time.sheet.pdf.report.generator.line;

import br.com.fiap.hackathon.time.sheet.pdf.report.generator.model.LineType;

import java.util.Map;

import static java.util.Map.entry;

public class LineBuilderFactory {

    private static final Map<LineType, Builder> MAP = Map.ofEntries(
            entry(LineType.DETAIL, DetailLineBuilder.builder())
    );

    public static LineBuilder get(LineType type) {
        return MAP.get(type).build();
    }

    interface Builder {
        LineBuilder build();
    }
}
