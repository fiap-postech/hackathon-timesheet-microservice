package br.com.fiap.hackathon.adapter.gateway.timesheet;

import br.com.fiap.hackathon.adapter.repository.PublishTimeSheetReportRepository;
import br.com.fiap.hackathon.adapter.repository.TimeSheetReaderRepository;
import br.com.fiap.hackathon.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.hackathon.adapter.repository.TimesheetReportRepository;
import br.com.fiap.hackathon.application.gateway.PublishTimeSheetReportGateway;
import br.com.fiap.hackathon.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.application.gateway.TimeTrackingWriterGateway;
import br.com.fiap.hackathon.application.gateway.TimesheetReportGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimesheetGatewayFactory {

    public static PublishTimeSheetReportGateway publishTimeSheetReportGateway(PublishTimeSheetReportRepository requestRepository) {
        return new PublishTimeSheetReportGatewayImpl(requestRepository);
    }

    public static TimesheetReportGateway timeSheetReportGateway(TimesheetReportRepository repository, TimeTrackingReaderGateway timeTrackingReaderGateway) {
        return new TimesheetReportGatewayImpl(repository, timeTrackingReaderGateway);
    }

    public static TimeTrackingWriterGateway timeTrackingWriterGateway(TimeSheetWriterRepository writerRepository) {
        return new TimeTrackingWriterGatewayImpl(writerRepository);
    }

    public static TimeTrackingReaderGateway timeTrackingReaderGateway(TimeSheetReaderRepository repository) {
        return new TimeTrackingReaderGatewayImpl(repository);
    }
}
