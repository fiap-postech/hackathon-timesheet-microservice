package br.com.fiap.hackathon.adapter.repository;

import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;

public interface TimesheetReportRepository {

    String write(TimesheetReportDTO dto);

    boolean isReportExist(TimesheetRequestDTO dto);
}
