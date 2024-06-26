package br.com.fiap.hackathon.timesheet.driven.timesheet.request.consumer.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_SHEET_REQUEST_QUEUE = "aws.resources.sqs.time-sheet-request.queue";

}
