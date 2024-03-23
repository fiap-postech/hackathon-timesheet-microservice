package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;

public interface PublishDataRemovalResponseGateway {
    void publishResponse(TimesheetRequestDTO dto);
}
