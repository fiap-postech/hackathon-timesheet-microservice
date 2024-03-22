package br.com.fiap.tech.challenge.adapter.controller.customer;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import br.com.fiap.tech.challenge.application.usecase.customer.TimeTrackingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
class TimeTrackingControllerImpl implements TimeTrackingController {

    private final TimeTrackingUseCase timeTrackingUseCase;

    @Override
    @Transactional
    public void saveTracking(TimeTrackingDTO dto) {
        timeTrackingUseCase.saveTracking(dto);
    }
}
