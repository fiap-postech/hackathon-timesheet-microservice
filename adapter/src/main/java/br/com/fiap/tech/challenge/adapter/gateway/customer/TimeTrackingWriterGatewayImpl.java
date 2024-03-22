package br.com.fiap.tech.challenge.adapter.gateway.customer;

import br.com.fiap.tech.challenge.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TimeTrackingWriterGatewayImpl implements TimeTrackingWriterGateway {

    private final TimeSheetWriterRepository writerRepository;

    @Override
    public void write(TimeTrackingDTO timeTrackingDTO) {
        writerRepository.write(timeTrackingDTO);
    }
}
