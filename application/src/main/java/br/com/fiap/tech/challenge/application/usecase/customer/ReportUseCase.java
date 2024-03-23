package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;

public interface ReportUseCase {

    void generate(TimesheetRequestDTO dto);

}
