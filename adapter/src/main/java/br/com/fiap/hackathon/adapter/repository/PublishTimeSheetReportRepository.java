package br.com.fiap.hackathon.adapter.repository;

import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;

public interface PublishTimeSheetReportRepository {

    void publish(TimesheetReportResponse timesheetReport);

}
