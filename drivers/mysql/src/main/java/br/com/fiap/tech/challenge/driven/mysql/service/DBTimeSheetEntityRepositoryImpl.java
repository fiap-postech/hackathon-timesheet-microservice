package br.com.fiap.tech.challenge.driven.mysql.service;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import br.com.fiap.tech.challenge.driven.mysql.mapping.DBTimeSheetMapper;
import br.com.fiap.tech.challenge.driven.mysql.model.TimeSheetEntity;
import br.com.fiap.tech.challenge.driven.mysql.repository.TimeSheetEntityRepository;
import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import br.com.fiap.tech.challenge.adapter.repository.CustomerReaderRepository;
import br.com.fiap.tech.challenge.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.TIMESHEET_NOT_FOUND_BY_EMPLOYEE;

@Service
@RequiredArgsConstructor
public class DBTimeSheetEntityRepositoryImpl implements TimeSheetWriterRepository, CustomerReaderRepository {

    private final TimeSheetEntityRepository repository;
    private final DBTimeSheetMapper mapper;

    @Override
    public Optional<CustomerDTO> readById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerDTO> readByDocument(String document) {
        return Optional.empty();
    }

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
        entity.setUuidStartRecord(dto.getEntries().getUuid());
        entity.setStartTimestamp(dto.getEntries().getTimestamp());
        entity.setYearMonth(dto.getDate().getYear()+"-"+ String.format("%02d",dto.getDate().getMonthValue()));
        return entity;
    }

    private void update(TimeTrackingDTO dto) {
        var timeSheetEntity = loadByEmployeeIdAndDate(dto.getEmployeeId(), dto.getDate());

        timeSheetEntity.setUuidEndRecord(dto.getEntries().getUuid());
        timeSheetEntity.setEndTimestamp(dto.getEntries().getTimestamp());

        var duration = Duration.between(timeSheetEntity.getStartTimestamp(), timeSheetEntity.getEndTimestamp());
        timeSheetEntity.setTotalWorkHours(LocalTime.MIDNIGHT.plus(duration));

        repository.save(timeSheetEntity);
    }

    private TimeSheetEntity loadByEmployeeIdAndDate(String employeeId, LocalDate date) {
        return repository.findByEmployeeIdAndDateAndUuidEndRecordIsNull(employeeId, date)
                .orElseThrow(() -> new ApplicationException(TIMESHEET_NOT_FOUND_BY_EMPLOYEE, employeeId, date.toString()));
    }
}