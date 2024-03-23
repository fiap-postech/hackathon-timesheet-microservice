package br.com.fiap.hackathon.driven.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "timesheet")
@Getter
@Setter
@ToString
public class TimeSheetEntity extends JPAEntity{

    @Serial
    private static final long serialVersionUID = -6898703406360602814L;

    @NotBlank
    @Column(name = "employee_id")
    private String employeeId;

    @NotNull
    @Column
    private LocalDate date;

    @NotBlank
    @Column(name = "year_and_month")
    private String yearMonth;

    @Column(name = "uuid_start_record")
    private String uuidStartRecord;

    @Column(name = "start_timestamp")
    private LocalTime startTimestamp;

    @Column(name = "uuid_end_record")
    private String uuidEndRecord;

    @Column(name = "end_timestamp")
    private LocalTime endTimestamp;

    @Column(name = "total_work_hours")
    private LocalTime totalWorkHours;
}
