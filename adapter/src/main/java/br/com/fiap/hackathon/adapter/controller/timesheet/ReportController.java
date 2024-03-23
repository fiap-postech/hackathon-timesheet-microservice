package br.com.fiap.hackathon.adapter.controller.timesheet;

import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;

public interface ReportController {

    void generate(TimesheetRequestDTO dto);

}
