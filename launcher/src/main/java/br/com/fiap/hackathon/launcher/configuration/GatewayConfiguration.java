package br.com.fiap.hackathon.launcher.configuration;

import br.com.fiap.hackathon.adapter.gateway.timesheet.TimesheetGatewayFactory;
import br.com.fiap.hackathon.adapter.repository.*;
import br.com.fiap.hackathon.application.gateway.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public PublishTimeSheetReportGateway publishTimeSheetReportGateway(PublishTimeSheetReportRepository requestRepository) {
        return TimesheetGatewayFactory.publishTimeSheetReportGateway(requestRepository);
    }

    @Bean
    public TimesheetReportGateway timesheetReportGateway(TimesheetReportRepository repository, TimeTrackingReaderGateway timeTrackingReaderGateway) {
        return TimesheetGatewayFactory.timeSheetReportGateway(repository, timeTrackingReaderGateway);
    }

    @Bean
    public TimeTrackingWriterGateway timeTrackingWriterGateway(TimeSheetWriterRepository writerRepository) {
        return TimesheetGatewayFactory.timeTrackingWriterGateway(writerRepository);
    }

    @Bean
    public TimeTrackingReaderGateway timeTrackingReaderGateway(TimeSheetReaderRepository repository) {
        return TimesheetGatewayFactory.timeTrackingReaderGateway(repository);
    }
}
