package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TimeTrackingUseCaseImpl implements TimeTrackingUseCase {

    private final TimeTrackingWriterGateway writerGateway;

    @Override
    public void saveTracking(TimeTrackingDTO dto) {
        writerGateway.write(dto);
    }
}
