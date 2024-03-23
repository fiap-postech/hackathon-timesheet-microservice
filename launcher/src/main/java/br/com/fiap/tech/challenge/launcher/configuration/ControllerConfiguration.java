package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.hackathon.adapter.controller.timesheet.ReportController;
import br.com.fiap.hackathon.adapter.controller.timesheet.TimeTrackingController;
import br.com.fiap.hackathon.adapter.controller.timesheet.TimesheetControllerFactory;
import br.com.fiap.hackathon.application.usecase.timesheet.ReportUseCase;
import br.com.fiap.hackathon.application.usecase.timesheet.TimeTrackingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {


    @Bean
    public TimeTrackingController timeTrackingController(TimeTrackingUseCase useCase) {
        return TimesheetControllerFactory.timeTrackingController(useCase);
    }

    @Bean
    public ReportController reportController(ReportUseCase useCase) {
        return TimesheetControllerFactory.reportController(useCase);
    }
}
