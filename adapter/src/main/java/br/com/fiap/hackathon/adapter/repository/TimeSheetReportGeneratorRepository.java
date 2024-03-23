package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;

public interface TimeSheetReportGeneratorRepository {

    byte[] generate(TimesheetReportDTO dto);

}
