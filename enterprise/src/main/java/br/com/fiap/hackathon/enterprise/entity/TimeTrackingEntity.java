package br.com.fiap.tech.challenge.enterprise.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class TimeTrackingEntity {

    private String employeeId;

    private LocalDate date;

    private String yearMonth;

    private String uuidStartRecord;

    private LocalTime startTimestamp;

    private String uuidEndRecord;

    private LocalTime endTimestamp;

    private LocalTime totalWorkHours;


    public LocalTime getTotalWorkHoursMonth(List<LocalTime> totalWorkHours) {
        AtomicReference<LocalTime> total = new AtomicReference<>(LocalTime.MIDNIGHT);

        totalWorkHours.forEach(time -> {
            total.set(total.get().plusHours(time.getHour()).plusMinutes(time.getMinute()).plusSeconds(time.getSecond()));
        });

        return total.get();
    }
}
