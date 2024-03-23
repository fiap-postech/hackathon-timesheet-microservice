package br.com.fiap.hackathon.adapter.gateway.timesheet;

import br.com.fiap.hackathon.adapter.repository.PublishTimeSheetReportRepository;
import br.com.fiap.hackathon.application.gateway.PublishTimeSheetReportGateway;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PublishTimeSheetReportGatewayImpl implements PublishTimeSheetReportGateway {

    private final PublishTimeSheetReportRepository requestRepository;

    @Override
    public void publish(TimesheetReportResponse timesheetReport) {
        requestRepository.publish(timesheetReport);
    }

}
