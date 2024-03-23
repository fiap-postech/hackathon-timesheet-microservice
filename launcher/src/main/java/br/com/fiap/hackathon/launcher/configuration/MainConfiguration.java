package br.com.fiap.hackathon.launcher.configuration;

import br.com.fiap.hackathon.driven.mysql.config.MySQLConfiguration;
import br.com.fiap.hackathon.time.sheet.pdf.report.generator.config.PDFReportConfiguration;
import br.com.fiap.hackathon.timesheet.driven.timesheet.producer.config.TimeSheetReportProducerConfiguration;
import br.com.fiap.hackathon.timesheet.driven.timesheet.report.producer.config.TimeSheetReportS3Configuration;
import br.com.fiap.hackathon.timesheet.driven.timesheet.request.consumer.config.TimeSheetRequestConsumerConfiguration;
import br.com.fiap.hackathon.timesheet.driven.timetracking.consumer.config.TimeTrackingConsumerConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
@Import({
        MySQLConfiguration.class,
        TimeSheetReportProducerConfiguration.class,
        TimeTrackingConsumerConfiguration.class,
        TimeSheetRequestConsumerConfiguration.class,
        TimeSheetReportS3Configuration.class,
        PDFReportConfiguration.class
})
public class MainConfiguration {

    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient client, ObjectMapper mapper) {
        return SqsTemplate.builder()
                .sqsAsyncClient(client)
                .configureDefaultConverter(converter -> {
                    converter.setObjectMapper(mapper);
                    converter.setPayloadTypeHeaderValueFunction(m -> null);
                })
                .build();
    }

}
