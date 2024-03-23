package br.com.fiap.tech.challenge.application.dto;

import br.com.fiap.tech.challenge.enterprise.enums.DataRemovalStatus;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    private LocalTime totalWorkHours;

}
