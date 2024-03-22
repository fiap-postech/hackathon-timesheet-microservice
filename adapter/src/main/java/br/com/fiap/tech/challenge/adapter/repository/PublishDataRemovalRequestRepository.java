package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;

public interface PublishDataRemovalRequestRepository {

    void publish(TimeTrackingDTO dto);

}
