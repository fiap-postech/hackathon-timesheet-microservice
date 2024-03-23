package br.com.fiap.hackathon.timesheet.driven.timetracking.consumer.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_TRACKING_EVENT_QUEUE = "aws.resources.sqs.time-tracking-event.queue";

}
