package br.com.fiap.hackathon.driven.mysql.service;

import br.com.fiap.hackathon.adapter.repository.TimeSheetReaderRepository;
import br.com.fiap.hackathon.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.driven.mysql.model.TimeSheetEntity;
import br.com.fiap.hackathon.driven.mysql.repository.TimeSheetEntityRepository;
import br.com.fiap.tech.challenge.enterprise.entity.TimeTrackingEntity;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.TIMESHEET_NOT_FOUND_BY_EMPLOYEE;

@Service
@RequiredArgsConstructor
public class DBTimeSheetEntityRepositoryImpl implements TimeSheetWriterRepository, TimeSheetReaderRepository {

    private final TimeSheetEntityRepository repository;

    @Override
    public void write(TimeTrackingDTO timeTrackingDTO) {
        if (repository.existsByEmployeeIdAndDateAndUuidEndRecordIsNull(timeTrackingDTO.getEmployeeId(), timeTrackingDTO.getDate())) {
            update(timeTrackingDTO);
        }else{
            insert(timeTrackingDTO);
        }
    }

    private void insert(TimeTrackingDTO dto) {
        TimeSheetEntity entity = getTimeSheetEntityByInsert(dto);
        repository.save(entity);
    }

    private TimeSheetEntity getTimeSheetEntityByInsert(TimeTrackingDTO dto) {
        TimeSheetEntity entity = new TimeSheetEntity();
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setDate(dto.getDate());
        entity.setUuidStartRecord(dto.getEntry().getUuid());
        entity.setStartTimestamp(dto.getEntry().getTimestamp());
        entity.setYearMonth(dto.getDate().getYear()+"-"+ String.format("%02d",dto.getDate().getMonthValue()));
        return entity;
    }

    private void update(TimeTrackingDTO dto) {
        var timeSheetEntity = loadByEmployeeIdAndDate(dto.getEmployeeId(), dto.getDate());

        timeSheetEntity.setUuidEndRecord(dto.getEntry().getUuid());
        timeSheetEntity.setEndTimestamp(dto.getEntry().getTimestamp());

        var duration = Duration.between(timeSheetEntity.getStartTimestamp(), timeSheetEntity.getEndTimestamp());
        timeSheetEntity.setTotalWorkHours(LocalTime.MIDNIGHT.plus(duration));

        repository.save(timeSheetEntity);
    }

    private TimeSheetEntity loadByEmployeeIdAndDate(String employeeId, LocalDate date) {
        return repository.findByEmployeeIdAndDateAndUuidEndRecordIsNull(employeeId, date)
                .orElseThrow(() -> new ApplicationException(TIMESHEET_NOT_FOUND_BY_EMPLOYEE, employeeId, date.toString()));
    }

    @Override
    public List<TimeTrackingEntity> read(TimesheetRequestDTO requestDTO) {
       var timeSheetEntities = repository.findByEmployeeIdAndYearMonth(requestDTO.getEmployeeId(), requestDTO.getYearMonth());
       return timeSheetEntities.stream().map(t -> TimeTrackingEntity.builder()
               .employeeId(t.getEmployeeId())
               .yearMonth(t.getYearMonth())
               .date(t.getDate())
               .uuidStartRecord(t.getUuidStartRecord())
               .startTimestamp(t.getStartTimestamp())
               .uuidEndRecord(t.getUuidEndRecord())
               .endTimestamp(t.getEndTimestamp())
               .totalWorkHours(t.getTotalWorkHours())
               .build()).toList();
    }
}