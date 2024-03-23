package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimeTrackingEntity;

import java.util.List;

public interface TimeSheetReaderRepository {
    List<TimeTrackingEntity> read(TimesheetRequestDTO requestDTO);
}
