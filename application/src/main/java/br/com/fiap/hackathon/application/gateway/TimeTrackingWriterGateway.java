package br.com.fiap.hackathon.application.gateway;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;

public interface TimeTrackingWriterGateway {
    void write(TimeTrackingDTO timeTrackingDTO);
}
