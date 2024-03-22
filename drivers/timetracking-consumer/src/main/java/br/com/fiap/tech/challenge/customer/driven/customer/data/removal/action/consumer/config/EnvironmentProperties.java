package br.com.fiap.tech.challenge.customer.driven.customer.data.removal.action.consumer.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_TRACKING_EVENT_QUEUE = "aws.resources.sqs.time-tracking-event.queue";

}
