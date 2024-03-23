package br.com.fiap.hackathon.time.sheet.pdf.report.generator.section;

import java.util.List;

public class SectionGeneratorFactory {

    private static final List<Builder> SECTIONS = List.of(
            HeaderSectionGenerator.builder(),
            DetailSectionGenerator.builder()
    );

    public static List<SectionGenerator> getSections() {
        return SECTIONS.stream()
                .map(Builder::build)
                .toList();
    }

    interface Builder {
        SectionGenerator build();
    }
}
