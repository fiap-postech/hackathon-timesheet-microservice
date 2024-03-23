package br.com.fiap.tech.challenge.customer.driven.customer.data.removal.response.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.controller.customer.ReportController;
import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.customer.driven.customer.data.removal.response.consumer.mapping.UpdateDataRemovalMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static br.com.fiap.tech.challenge.customer.driven.customer.data.removal.response.consumer.config.EnvironmentProperties.TIME_SHEET_REQUEST_QUEUE;


@Component
@RequiredArgsConstructor
public class TimesheetRequestListener {

    private final ReportController controller;

    @SqsListener(value = "${" + TIME_SHEET_REQUEST_QUEUE + "}")
    public void listen(Message<TimesheetRequestDTO> message) {
        controller.generate(message.getPayload());
    }

}
