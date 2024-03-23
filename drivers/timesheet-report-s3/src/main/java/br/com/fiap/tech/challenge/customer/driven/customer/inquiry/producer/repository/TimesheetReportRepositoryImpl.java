package br.com.fiap.tech.challenge.customer.driven.customer.inquiry.producer.repository;

import br.com.fiap.tech.challenge.adapter.repository.TimesheetReportRepository;
import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static br.com.fiap.tech.challenge.customer.driven.customer.inquiry.producer.config.EnvironmentProperties.TIME_SHEET_BUCKET;
import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.UNKNOWN_ERROR;

@Service
@RequiredArgsConstructor
public class TimesheetReportRepositoryImpl implements TimesheetReportRepository {

    private final ObjectMapper mapper;

    private final S3Template s3;

    @Value("${" + TIME_SHEET_BUCKET + "}")
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
        var listObject = s3.listObjects(bucketName,key);

        return !listObject.isEmpty();
    }
}
