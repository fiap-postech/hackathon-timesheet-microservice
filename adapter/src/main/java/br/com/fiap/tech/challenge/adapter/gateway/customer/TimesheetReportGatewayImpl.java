package br.com.fiap.tech.challenge.adapter.gateway.customer;

import br.com.fiap.tech.challenge.adapter.repository.TimesheetReportRepository;
import br.com.fiap.tech.challenge.application.dto.TimeTrackingReportDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.TimesheetReportGateway;
import br.com.fiap.tech.challenge.enterprise.entity.TimeTrackingEntity;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;

import static br.com.fiap.tech.challenge.adapter.dto.EnvironmentProperties.TIME_SHEET_BUCKET;

@RequiredArgsConstructor
class TimesheetReportGatewayImpl implements TimesheetReportGateway {

    @Value("${" + TIME_SHEET_BUCKET + "}")
    private String bucketName;

    private final TimesheetReportRepository repository;
    private final TimeTrackingReaderGateway readerGateway;

    @Override
    public TimesheetReportResponse write(TimesheetRequestDTO dto) {
        var key = dto.getEmployeeId() + "/" + dto.getYearMonth() + ".pdf";

        if(repository.isReportExist(dto)){
            return TimesheetReportResponse.builder()
                    .bucket(bucketName)
                    .employeeEmail(dto.getEmployeeEmail())
                    .employeeId(dto.getEmployeeId())
                    .key(key)
                    .build();
        }else{
            var timeSheetEntities = readerGateway.read(dto);
            var totalWorkHoursList = timeSheetEntities.stream().map(TimeTrackingEntity::getTotalWorkHours).toList();
            var totalWorkHoursMonthOpt = timeSheetEntities.stream().map(t -> t.getTotalWorkHoursMonth(totalWorkHoursList)).findFirst();

            var timeSheetReportDTO = TimesheetReportDTO.builder().employeeId(dto.getEmployeeId())
                    .yearMonth(dto.getYearMonth())
                    .totalWorkHoursMonth(totalWorkHoursMonthOpt.orElse(LocalTime.MIDNIGHT))
                    .build();

            var timeSheetList = timeSheetEntities.stream().map(e -> TimeTrackingReportDTO.builder()
                    .date(e.getDate())
                    .uuidStartRecord(e.getUuidStartRecord())
                    .startTimestamp(e.getStartTimestamp())
                    .uuidEndRecord(e.getUuidEndRecord())
                    .endTimestamp(e.getEndTimestamp())
                    .totalWorkHours(e.getTotalWorkHours())
                    .build()).toList();

            timeSheetReportDTO.setTimesheets(timeSheetList);

            return repository.write(timeSheetReportDTO);
        }
    }
}
