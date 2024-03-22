package br.com.fiap.tech.challenge.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TimeTrackingDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8677798649557560227L;

    private String uuid;
    private String employeeId;
    private LocalDate date;
    private EntryDTO entries;
}