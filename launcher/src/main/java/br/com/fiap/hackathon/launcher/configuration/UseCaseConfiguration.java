package br.com.fiap.hackathon.launcher.configuration;

import br.com.fiap.hackathon.application.gateway.PublishTimeSheetReportGateway;
import br.com.fiap.hackathon.application.gateway.TimeTrackingWriterGateway;
import br.com.fiap.hackathon.application.gateway.TimesheetReportGateway;
import br.com.fiap.hackathon.application.usecase.timesheet.ReportUseCase;
import br.com.fiap.hackathon.application.usecase.timesheet.TimeSheetUseCaseFactory;
import br.com.fiap.hackathon.application.usecase.timesheet.TimeTrackingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public TimeTrackingUseCase timeTrackingUseCase(TimeTrackingWriterGateway writerGateway) {
        return TimeSheetUseCaseFactory.timeTrackingUseCase(writerGateway);
    }

    @Bean
    public ReportUseCase reportUseCase(TimesheetReportGateway timesheetReportGateway, PublishTimeSheetReportGateway publish) {
        return TimeSheetUseCaseFactory.reportUseCase(timesheetReportGateway,publish);
    }
}