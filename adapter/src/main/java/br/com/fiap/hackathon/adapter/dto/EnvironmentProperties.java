package br.com.fiap.hackathon.adapter.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String TIME_SHEET_BUCKET = "aws.resources.s3.time-sheet.bucket";

}
