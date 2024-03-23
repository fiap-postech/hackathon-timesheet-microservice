package br.com.fiap.hackathon.adapter.repository;


import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;

public interface TimeSheetReportGeneratorRepository {

    byte[] generate(TimesheetReportDTO dto);

}
