package br.com.fiap.tech.challenge.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
@Setter
@Accessors(chain = true)
public class TimesheetReportDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -5006551194085986509L;

    private String employeeId;

    private String yearMonth;

    private LocalTime totalWorkHoursMonth;

    private List<TimeTrackingReportDTO> timesheets;
}
