package br.com.fiap.hackathon.timesheet.driven.timesheet.producer.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_TRACKING_EVENT_TOPIC = "aws.resources.sns.time-tracking-event.topic";

}
