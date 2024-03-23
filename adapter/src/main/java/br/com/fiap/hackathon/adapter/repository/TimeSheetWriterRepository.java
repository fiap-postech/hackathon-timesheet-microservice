package br.com.fiap.hackathon.adapter.repository;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;

public interface TimeSheetWriterRepository {
    void write(TimeTrackingDTO timeTrackingDTO);
}
