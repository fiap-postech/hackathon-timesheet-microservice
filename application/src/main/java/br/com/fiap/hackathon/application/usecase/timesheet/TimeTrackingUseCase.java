package br.com.fiap.hackathon.application.usecase.timesheet;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;

public interface TimeTrackingUseCase {

    void saveTracking(TimeTrackingDTO dto);

}
