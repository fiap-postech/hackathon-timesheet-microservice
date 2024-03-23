package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;

public interface PublishDataRemovalResponseRepository {

    void publish(TimesheetRequestDTO dto);

}
