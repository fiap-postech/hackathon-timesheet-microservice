package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimeTrackingEntity;

import java.util.List;

public interface TimeTrackingReaderGateway {
    List<TimeTrackingEntity> read(TimesheetRequestDTO requestDTO);
}
