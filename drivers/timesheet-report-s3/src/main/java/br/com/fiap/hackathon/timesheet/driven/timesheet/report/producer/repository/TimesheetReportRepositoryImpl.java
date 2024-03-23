package br.com.fiap.hackathon.timesheet.driven.timesheet.report.producer.repository;

import br.com.fiap.hackathon.adapter.repository.TimeSheetReportGeneratorRepository;
import br.com.fiap.hackathon.adapter.repository.TimesheetReportRepository;
import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.timesheet.driven.timesheet.report.producer.config.EnvironmentProperties;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.UNKNOWN_ERROR;

@Service
@RequiredArgsConstructor
public class TimesheetReportRepositoryImpl implements TimesheetReportRepository {

    private final S3Template s3;

    @Value("${" + EnvironmentProperties.TIME_SHEET_BUCKET + "}")
    private String bucketName;

    private final TimeSheetReportGeneratorRepository repository;

    @Override
    public String write(TimesheetReportDTO dto) {
        try {
            var output = repository.generate(dto);

            var key = this.getKey(dto.getEmployeeId(), dto.getYearMonth());

            s3.upload(bucketName, key, new ByteArrayInputStream(output));

            return key;
        } catch (Exception e) {
            throw new ApplicationException(UNKNOWN_ERROR, e.getMessage());
        }
    }

    @Override
    public boolean isReportExist(TimesheetRequestDTO dto) {
        var key = this.getKey(dto.getEmployeeId(), dto.getYearMonth());
        var listObject = s3.listObjects(bucketName,key);

        return !listObject.isEmpty();
    }

    private String getKey(String employeeId, String yearMonth) {
        return employeeId + "/" + yearMonth + ".pdf";
    }
}
