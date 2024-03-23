package br.com.fiap.tech.challenge.customer.driven.customer.inquiry.producer.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_SHEET_BUCKET = "aws.resources.s3.time-sheet.bucket";

}
