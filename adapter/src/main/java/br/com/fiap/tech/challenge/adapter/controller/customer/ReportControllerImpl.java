package br.com.fiap.tech.challenge.adapter.controller.customer;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.application.dto.UpdateDataRemovalDTO;
import br.com.fiap.tech.challenge.application.usecase.customer.ReportUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ReportControllerImpl implements ReportController {

    private final ReportUseCase useCase;

    @Override
    public void generate(TimesheetRequestDTO dto) {
        useCase.generate(dto);
    }
}
