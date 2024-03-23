package br.com.fiap.hackathon.adapter.controller.timesheet;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.application.usecase.timesheet.TimeTrackingUseCase;
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
