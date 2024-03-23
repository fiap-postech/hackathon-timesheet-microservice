package br.com.fiap.tech.challenge.adapter.controller.customer;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;

public interface ReportController {

    void generate(TimesheetRequestDTO dto);

}
