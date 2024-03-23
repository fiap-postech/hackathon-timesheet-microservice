package br.com.fiap.hackathon.timesheet.driven.timesheet.producer.messaging;

import br.com.fiap.hackathon.adapter.repository.PublishTimeSheetReportRepository;
import br.com.fiap.hackathon.timesheet.driven.timesheet.producer.config.EnvironmentProperties;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;
import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TimeSheetReportProducer implements PublishTimeSheetReportRepository {

    @Value("${" + EnvironmentProperties.TIME_TRACKING_EVENT_TOPIC + "}")
    private String topicName;

    private final SnsTemplate sns;


    @Override
    public void publish(TimesheetReportResponse timesheetReport) {
        sns.convertAndSend(topicName, timesheetReport);
    }
}
