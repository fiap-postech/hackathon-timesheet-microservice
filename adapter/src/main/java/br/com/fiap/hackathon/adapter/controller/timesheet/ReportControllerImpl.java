package br.com.fiap.hackathon.adapter.controller.timesheet;

import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.application.usecase.timesheet.ReportUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ReportControllerImpl implements ReportController {

    private final ReportUseCase useCase;

    @Override
    public void generate(TimesheetRequestDTO dto) {
        useCase.generate(dto);
    }
}
