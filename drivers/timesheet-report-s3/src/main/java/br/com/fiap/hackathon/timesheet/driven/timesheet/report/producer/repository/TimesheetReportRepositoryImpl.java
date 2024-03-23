package br.com.fiap.hackathon.timesheet.driven.timesheet.report.producer.repository;

import br.com.fiap.hackathon.adapter.repository.TimesheetReportRepository;
import br.com.fiap.hackathon.application.dto.TimesheetReportDTO;
import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.hackathon.timesheet.driven.timesheet.report.producer.config.EnvironmentProperties;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.UNKNOWN_ERROR;

@Service
@RequiredArgsConstructor
public class TimesheetReportRepositoryImpl implements TimesheetReportRepository {

    private final S3Template s3;

    @Value("${" + EnvironmentProperties.TIME_SHEET_BUCKET + "}")
    private String bucketName;

    @Override
    public TimesheetReportResponse write(TimesheetReportDTO dto) {
        try {

            //TODO: Implementar geracao do pdf

            var key = dto.getEmployeeId() + "/" + dto.getYearMonth() + ".pdf";
            s3.store(
                    bucketName,
                    key,
                    dto
            );
        } catch (Exception e) {
            throw new ApplicationException(UNKNOWN_ERROR, e.getMessage());
        }
        return null;
    }

    @Override
    public boolean isReportExist(TimesheetRequestDTO dto) {
        var key = dto.getEmployeeId() + "/" + dto.getYearMonth() + ".pdf";
        var listaObject = s3.listObjects(bucketName,key);

        return listaObject.size() > 0;
    }
}
