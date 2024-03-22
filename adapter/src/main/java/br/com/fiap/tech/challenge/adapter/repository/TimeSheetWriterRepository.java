package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;

public interface TimeSheetWriterRepository {
    void write(TimeTrackingDTO timeTrackingDTO);
}
