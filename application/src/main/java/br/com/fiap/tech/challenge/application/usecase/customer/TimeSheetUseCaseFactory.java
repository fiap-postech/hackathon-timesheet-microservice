package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.gateway.CustomerReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.TimesheetReportGateway;
import br.com.fiap.tech.challenge.application.gateway.DataRemovalReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.DataRemovalWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.PublishDataRemovalRequestGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeSheetUseCaseFactory {

    public static CreateCustomerUseCase createCustomerService(TimeTrackingWriterGateway writer, CustomerReaderGateway reader) {
        return new CreateCustomerUseCaseImpl(writer, reader);
    }

    public static UpgradeCustomerUseCase upgradeCustomerService(TimeTrackingWriterGateway writer, CustomerReaderGateway reader) {
        return new UpgradeCustomerUseCaseImpl(writer, reader);
    }

    public static FindCustomerByDocumentUseCase findCustomerByDocumentService(CustomerReaderGateway reader) {
        return new FindCustomerByDocumentUseCaseImpl(reader);
    }

    public static FindCustomerByUUIDUseCase findFindCustomerByUUIDService(CustomerReaderGateway reader) {
        return new FindCustomerByUUIDUseCaseImpl(reader);
    }

    public static FindDataRemovalByUUIDUseCase findDataRemovalByUUIDUseCase(DataRemovalReaderGateway gateway) {
        return new FindDataRemovalByUUIDUseCaseImpl(gateway);
    }

    public static TimeTrackingUseCase saveTracking(TimeTrackingWriterGateway writerGateway) {
        return new TimeTrackingUseCaseImpl(writerGateway);
    }

    public static ReportUseCase updateDataRemovalUseCase(TimesheetReportGateway timesheetReportGateway) {
        return new ReportUseCaseImpl(timesheetReportGateway);
    }

    public static PublishDataRemovalUseCase publishDataRemovalUseCase(PublishDataRemovalRequestGateway requestGateway,
                                                                      CustomerReaderGateway customerReaderGateway) {
        return new PublishDataRemovalUseCaseImpl(requestGateway, customerReaderGateway);
    }
}
