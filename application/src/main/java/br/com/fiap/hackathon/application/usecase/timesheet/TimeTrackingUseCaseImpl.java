package br.com.fiap.hackathon.application.usecase.timesheet;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.application.gateway.TimeTrackingWriterGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TimeTrackingUseCaseImpl implements TimeTrackingUseCase {

    private final TimeTrackingWriterGateway writerGateway;

    @Override
    public void saveTracking(TimeTrackingDTO dto) {
        writerGateway.write(dto);
    }
}
