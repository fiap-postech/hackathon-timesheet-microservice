package br.com.fiap.hackathon.application.usecase.timesheet;

import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.application.gateway.PublishTimeSheetReportGateway;
import br.com.fiap.hackathon.application.gateway.TimesheetReportGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ReportUseCaseImpl implements ReportUseCase {

    private final TimesheetReportGateway reportGateway;
    private final PublishTimeSheetReportGateway publishTimeSheetReportGateway;


    @Override
    public void generate(TimesheetRequestDTO dto) {
        var reportPayload = reportGateway.write(dto);
        publishTimeSheetReportGateway.publish(reportPayload);
    }
}
