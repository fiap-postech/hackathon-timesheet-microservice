package br.com.fiap.tech.challenge.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors
public class TimesheetRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6734072752820724699L;


    private String employeeId;
    private String employeeEmail;
    private String yearMonth;

}
