package br.com.fiap.hackathon.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
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

    private List<TimeTrackingReportDTO> timesheet;

    public Duration getTotalWorkedHours() {
        return timesheet.stream()
                .map(TimeTrackingReportDTO::getTotalWorkedHours)
                .reduce(Duration::plus)
                .orElseThrow();
    }
}
