package br.com.fiap.hackathon.adapter.repository;

import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;

public interface TimesheetReportRepository {

    TimesheetReportResponse write(TimesheetReportDTO dto);

    boolean isReportExist(TimesheetRequestDTO dto);
}
