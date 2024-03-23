package br.com.fiap.hackathon.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.util.Objects.nonNull;

@Getter
@Builder
@Setter
public class TimeTrackingReportDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1344171704339193682L;

    private LocalDate date;

    private String uuidStartRecord;

    private LocalTime startTimestamp;

    private String uuidEndRecord;

    private LocalTime endTimestamp;

    public boolean isConsistent(){
        return nonNull(endTimestamp);
    }

    public Duration getTotalWorkedHours() {
        if (!isConsistent()) {
            return Duration.ZERO;
        }

        return Duration.between(startTimestamp, endTimestamp);
    }

}
