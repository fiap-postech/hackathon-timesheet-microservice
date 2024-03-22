package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;

public interface TimeTrackingUseCase {

    void saveTracking(TimeTrackingDTO dto);

}
