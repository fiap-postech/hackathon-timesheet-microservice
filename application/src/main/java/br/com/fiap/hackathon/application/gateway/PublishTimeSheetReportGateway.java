package br.com.fiap.hackathon.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;

public interface PublishTimeSheetReportGateway {

    void publish(TimesheetReportResponse timesheetReport);
}
