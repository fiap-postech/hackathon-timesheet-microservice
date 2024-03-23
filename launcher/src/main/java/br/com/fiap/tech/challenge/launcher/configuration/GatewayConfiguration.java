package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.gateway.customer.CustomerGatewayFactory;
import br.com.fiap.tech.challenge.adapter.repository.*;
import br.com.fiap.tech.challenge.application.gateway.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public TimeTrackingWriterGateway customerWriterGateway(TimeSheetWriterRepository writerRepository) {
        return CustomerGatewayFactory.customerWriterGateway(writerRepository);
    }

    @Bean
    public CustomerReaderGateway customerReaderGateway(CustomerReaderRepository repository) {
        return CustomerGatewayFactory.customerReaderGateway(repository);
    }

    @Bean
    public PublishDataRemovalRequestGateway publishDataRemovalRequestGateway(PublishDataRemovalRequestRepository requestRepository) {
        return CustomerGatewayFactory.publishDataRemovalRequestGateway(requestRepository);
    }

    @Bean
    public PublishDataRemovalResponseGateway publishDataRemovalResponseGateway(PublishDataRemovalResponseRepository responseRepository) {
        return CustomerGatewayFactory.publishDataRemovalResponseGateway(responseRepository);
    }

    @Bean
    public TimesheetReportGateway dataRemovalInquiryGateway(TimesheetReportRepository repository, TimeTrackingReaderGateway timeTrackingReaderGateway) {
        return CustomerGatewayFactory.dataRemovalInquiryGateway(repository, timeTrackingReaderGateway);
    }

    @Bean
    public TimeTrackingReaderGateway getTimeTrackingReaderGateway(TimeSheetReaderRepository repository) {
        return CustomerGatewayFactory.getTimetrackingReaderRepository(repository);
    }
}
