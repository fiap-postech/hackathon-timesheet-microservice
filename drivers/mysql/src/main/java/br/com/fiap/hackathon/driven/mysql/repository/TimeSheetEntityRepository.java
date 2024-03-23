package br.com.fiap.hackathon.driven.mysql.repository;

import br.com.fiap.hackathon.driven.mysql.model.TimeSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimeSheetEntityRepository extends JpaRepository<TimeSheetEntity, Long> {

    boolean existsByEmployeeIdAndDateAndUuidEndRecordIsNull(String employeeId, LocalDate date);

    Optional<TimeSheetEntity> findByEmployeeIdAndDateAndUuidEndRecordIsNull(String employeeId, LocalDate date);

    List<TimeSheetEntity> findByEmployeeIdAndYearMonth(String employeeId, String yearMonth);
}
