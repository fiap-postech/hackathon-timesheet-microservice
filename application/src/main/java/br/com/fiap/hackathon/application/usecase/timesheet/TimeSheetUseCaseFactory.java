package br.com.fiap.hackathon.application.usecase.timesheet;

import br.com.fiap.hackathon.application.gateway.PublishTimeSheetReportGateway;
import br.com.fiap.hackathon.application.gateway.TimeTrackingWriterGateway;
import br.com.fiap.hackathon.application.gateway.TimesheetReportGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeSheetUseCaseFactory {

    public static TimeTrackingUseCase timeTrackingUseCase(TimeTrackingWriterGateway writerGateway) {
        return new TimeTrackingUseCaseImpl(writerGateway);
    }

    public static ReportUseCase reportUseCase(TimesheetReportGateway timesheetReportGateway, PublishTimeSheetReportGateway publish) {
        return new ReportUseCaseImpl(timesheetReportGateway,publish);
    }

}
