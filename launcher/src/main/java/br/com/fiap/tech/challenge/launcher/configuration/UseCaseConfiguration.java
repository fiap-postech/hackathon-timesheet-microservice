package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.CustomerReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.TimesheetReportGateway;
import br.com.fiap.tech.challenge.application.gateway.DataRemovalReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.DataRemovalWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.PublishDataRemovalRequestGateway;
import br.com.fiap.tech.challenge.application.usecase.customer.CreateCustomerUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.TimeSheetUseCaseFactory;
import br.com.fiap.tech.challenge.application.usecase.customer.FindCustomerByDocumentUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.FindCustomerByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.FindDataRemovalByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.PublishDataRemovalUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.TimeTrackingUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.RequestDataRemovalUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.ReportUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.UpgradeCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateCustomerUseCase createCustomerService(TimeTrackingWriterGateway writer, CustomerReaderGateway reader) {
        return TimeSheetUseCaseFactory.createCustomerService(writer, reader);
    }

    @Bean
    public UpgradeCustomerUseCase upgradeCustomerService(TimeTrackingWriterGateway writer, CustomerReaderGateway reader) {
        return TimeSheetUseCaseFactory.upgradeCustomerService(writer, reader);
    }

    @Bean
    public FindCustomerByDocumentUseCase findCustomerByDocumentService(CustomerReaderGateway reader) {
        return TimeSheetUseCaseFactory.findCustomerByDocumentService(reader);
    }

    @Bean
    public FindCustomerByUUIDUseCase findCustomerByUUIDService(CustomerReaderGateway reader) {
        return TimeSheetUseCaseFactory.findFindCustomerByUUIDService(reader);
    }

    @Bean
    public FindDataRemovalByUUIDUseCase findDataRemovalByUUIDUseCase(DataRemovalReaderGateway gateway) {
        return TimeSheetUseCaseFactory.findDataRemovalByUUIDUseCase(gateway);
    }

    @Bean
    public TimeTrackingUseCase removeDataUseCase(TimeTrackingWriterGateway writerGateway) {
        return TimeSheetUseCaseFactory.saveTracking(writerGateway);
    }

    @Bean
    public ReportUseCase updateDataRemovalUseCase(TimesheetReportGateway timesheetReportGateway) {
        return TimeSheetUseCaseFactory.updateDataRemovalUseCase(timesheetReportGateway);
    }

    @Bean
    public PublishDataRemovalUseCase publishDataRemovalUseCase(PublishDataRemovalRequestGateway requestGateway,
                                                               CustomerReaderGateway customerReaderGateway) {
        return TimeSheetUseCaseFactory.publishDataRemovalUseCase(requestGateway, customerReaderGateway);
    }
}