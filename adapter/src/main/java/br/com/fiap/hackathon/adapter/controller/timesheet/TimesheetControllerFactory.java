package br.com.fiap.hackathon.adapter.controller.timesheet;

import br.com.fiap.hackathon.application.usecase.timesheet.ReportUseCase;
import br.com.fiap.hackathon.application.usecase.timesheet.TimeTrackingUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimesheetControllerFactory {

    public static ReportController reportController(ReportUseCase useCase) {
        return new ReportControllerImpl(useCase);
    }

    public static TimeTrackingController timeTrackingController(TimeTrackingUseCase useCase) {
        return new TimeTrackingControllerImpl(useCase);
    }
}
