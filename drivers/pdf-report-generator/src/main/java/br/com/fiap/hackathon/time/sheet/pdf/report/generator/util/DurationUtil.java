package br.com.fiap.hackathon.time.sheet.pdf.report.generator.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DurationUtil {

    public static String durationToString(Duration duration) {
        return String.format("%d horas %d minutos %d segundos", duration.toHours(), duration.toMinutes() % 60, duration.toSeconds() % 60);
    }

    public static String durationToSimpleString(Duration duration) {
        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes() % 60, duration.toSeconds() % 60);
    }
}
