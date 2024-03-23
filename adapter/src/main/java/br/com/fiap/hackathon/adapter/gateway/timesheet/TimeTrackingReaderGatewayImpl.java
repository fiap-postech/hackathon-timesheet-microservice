package br.com.fiap.hackathon.adapter.gateway.timesheet;

import br.com.fiap.hackathon.adapter.repository.TimeSheetReaderRepository;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.TimeTrackingEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class TimeTrackingReaderGatewayImpl implements TimeTrackingReaderGateway {

    private final TimeSheetReaderRepository readerRepository;


    @Override
    public List<TimeTrackingEntity> read(TimesheetRequestDTO requestDTO) {
        return readerRepository.read(requestDTO);
    }
}
