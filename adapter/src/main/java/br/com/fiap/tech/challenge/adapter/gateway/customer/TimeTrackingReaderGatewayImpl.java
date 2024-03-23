package br.com.fiap.tech.challenge.adapter.gateway.customer;

import br.com.fiap.tech.challenge.adapter.repository.TimeSheetReaderRepository;
import br.com.fiap.tech.challenge.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
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
