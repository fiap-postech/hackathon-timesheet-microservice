package br.com.fiap.hackathon.application.usecase.timesheet;

import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;

public interface ReportUseCase {

    void generate(TimesheetRequestDTO dto);

}
