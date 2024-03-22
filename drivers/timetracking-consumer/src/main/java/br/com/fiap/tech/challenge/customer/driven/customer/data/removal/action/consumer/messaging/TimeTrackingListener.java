package br.com.fiap.tech.challenge.customer.driven.customer.data.removal.action.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.controller.customer.TimeTrackingController;
import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static br.com.fiap.tech.challenge.customer.driven.customer.data.removal.action.consumer.config.EnvironmentProperties.TIME_TRACKING_EVENT_QUEUE;


@Component
@RequiredArgsConstructor
public class TimeTrackingListener {

    private final TimeTrackingController controller;

    @SqsListener("${" + TIME_TRACKING_EVENT_QUEUE + "}")
    public void register(Message<TimeTrackingDTO> message) {
        controller.saveTracking(message.getPayload());
    }

}
