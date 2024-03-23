package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;

public interface TimesheetReportRepository {

    TimesheetReportResponse write(TimesheetReportDTO dto);

    boolean isReportExist(TimesheetRequestDTO dto);
}
