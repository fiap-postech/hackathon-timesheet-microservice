package br.com.fiap.hackathon.adapter.gateway.timesheet;

import br.com.fiap.hackathon.adapter.dto.EnvironmentProperties;
import br.com.fiap.hackathon.adapter.repository.TimesheetReportRepository;
import br.com.fiap.hackathon.application.dto.TimeTrackingReportDTO;
import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.application.gateway.TimesheetReportGateway;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
class TimesheetReportGatewayImpl implements TimesheetReportGateway {

    @Value("${" + EnvironmentProperties.TIME_SHEET_BUCKET + "}")
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

            var timeSheetReportDTO = TimesheetReportDTO.builder().employeeId(dto.getEmployeeId())
                    .yearMonth(dto.getYearMonth())
                    .build();

            var timeSheetList = timeSheetEntities.stream().map(e -> TimeTrackingReportDTO.builder()
                    .date(e.getDate())
                    .uuidStartRecord(e.getUuidStartRecord())
                    .startTimestamp(e.getStartTimestamp())
                    .uuidEndRecord(e.getUuidEndRecord())
                    .endTimestamp(e.getEndTimestamp())
                    .build()
            ).toList();

            timeSheetReportDTO.setTimesheet(timeSheetList);

            return TimesheetReportResponse.builder()
                    .bucket(bucketName)
                    .employeeEmail(dto.getEmployeeEmail())
                    .employeeId(dto.getEmployeeId())
                    .key(repository.write(timeSheetReportDTO))
                    .build();
        }
    }
}
