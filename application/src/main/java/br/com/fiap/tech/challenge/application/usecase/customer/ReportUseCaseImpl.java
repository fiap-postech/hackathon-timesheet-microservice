package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.application.gateway.TimesheetReportGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ReportUseCaseImpl implements ReportUseCase {

    private final TimesheetReportGateway reportGateway;


    @Override
    public void generate(TimesheetRequestDTO dto) {
        reportGateway.write(dto);
    }
}
