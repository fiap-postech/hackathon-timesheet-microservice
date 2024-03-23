package br.com.fiap.tech.challenge.enterprise.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class TimesheetReportResponse {

    private String bucket;
    private String key;
    private String employeeEmail;
    private String employeeId;

}