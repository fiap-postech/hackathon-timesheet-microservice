package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;

public interface TimeTrackingWriterGateway {
    void write(TimeTrackingDTO timeTrackingDTO);
}
