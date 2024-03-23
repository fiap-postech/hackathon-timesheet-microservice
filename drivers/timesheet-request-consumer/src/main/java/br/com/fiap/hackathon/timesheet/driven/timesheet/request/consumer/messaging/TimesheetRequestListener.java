package br.com.fiap.hackathon.timesheet.driven.timesheet.request.consumer.messaging;

import br.com.fiap.hackathon.adapter.controller.timesheet.ReportController;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static br.com.fiap.hackathon.timesheet.driven.timesheet.request.consumer.config.EnvironmentProperties.TIME_SHEET_REQUEST_QUEUE;


@Component
@RequiredArgsConstructor
public class TimesheetRequestListener {

    private final ReportController controller;

    @SqsListener(value = "${" + TIME_SHEET_REQUEST_QUEUE + "}")
    public void listen(Message<TimesheetRequestDTO> message) {
        controller.generate(message.getPayload());
    }

}
