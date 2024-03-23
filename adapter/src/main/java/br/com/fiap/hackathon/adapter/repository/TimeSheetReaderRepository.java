package br.com.fiap.hackathon.adapter.repository;

import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimeTrackingEntity;

import java.util.List;

public interface TimeSheetReaderRepository {
    List<TimeTrackingEntity> read(TimesheetRequestDTO requestDTO);
}
