package br.com.fiap.hackathon.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@Accessors(chain = true)
public class EntryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8677798649557560227L;

    private String uuid;
    private LocalTime timestamp;

}