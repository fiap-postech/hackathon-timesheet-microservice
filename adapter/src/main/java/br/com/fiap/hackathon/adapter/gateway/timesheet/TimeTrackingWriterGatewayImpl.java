package br.com.fiap.hackathon.adapter.gateway.timesheet;

import br.com.fiap.hackathon.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.application.gateway.TimeTrackingWriterGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class TimeTrackingWriterGatewayImpl implements TimeTrackingWriterGateway {

    private final TimeSheetWriterRepository writerRepository;

    @Override
    public void write(TimeTrackingDTO timeTrackingDTO) {
        writerRepository.write(timeTrackingDTO);
    }
}
