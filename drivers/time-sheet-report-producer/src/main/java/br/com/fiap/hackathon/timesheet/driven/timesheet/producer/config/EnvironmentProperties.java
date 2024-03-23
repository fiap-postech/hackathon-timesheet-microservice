package br.com.fiap.hackathon.timesheet.driven.timesheet.producer.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_TRACKING_NOTIFICATION_REQUEST_QUEUE = "aws.resources.sqs.time-sheet-notification-request.queue";

}
