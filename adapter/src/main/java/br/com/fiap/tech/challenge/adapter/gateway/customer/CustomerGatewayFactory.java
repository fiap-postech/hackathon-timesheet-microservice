package br.com.fiap.tech.challenge.adapter.gateway.customer;

import br.com.fiap.tech.challenge.adapter.repository.*;
import br.com.fiap.tech.challenge.application.gateway.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerGatewayFactory {

    public static TimeTrackingWriterGateway customerWriterGateway(TimeSheetWriterRepository writerRepository) {
        return new TimeTrackingWriterGatewayImpl(writerRepository);
    }

    public static CustomerReaderGateway customerReaderGateway(CustomerReaderRepository readerRepository){
        return new CustomerReaderGatewayImpl(readerRepository);
    }

    public static PublishDataRemovalRequestGateway publishDataRemovalRequestGateway(PublishDataRemovalRequestRepository requestRepository) {
        return new PublishDataRemovalRequestGatewayImpl(requestRepository);
    }

    public static PublishDataRemovalResponseGateway publishDataRemovalResponseGateway(PublishDataRemovalResponseRepository responseRepository) {
        return new PublishDataRemovalResponseGatewayImpl(responseRepository);
    }

    public static TimesheetReportGateway dataRemovalInquiryGateway(TimesheetReportRepository repository, TimeTrackingReaderGateway timeTrackingReaderGateway) {
        return new TimesheetReportGatewayImpl(repository, timeTrackingReaderGateway);
    }

    public static TimeTrackingReaderGateway getTimetrackingReaderRepository(TimeSheetReaderRepository repository) {
        return new TimeTrackingReaderGatewayImpl(repository);
    }
}
