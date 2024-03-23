package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.hackathon.driven.mysql.config.MySQLConfiguration;
import br.com.fiap.hackathon.timesheet.driven.timesheet.producer.config.TimeSheetReportProducerConfiguration;
import br.com.fiap.hackathon.timesheet.driven.timesheet.report.producer.config.TimeSheetReportS3Configuration;
import br.com.fiap.hackathon.timesheet.driven.timesheet.request.consumer.config.TimeSheetRequestConsumerConfiguration;
import br.com.fiap.hackathon.timesheet.driven.timetracking.consumer.config.TimeTrackingConsumerConfiguration;
import io.awspring.cloud.sns.core.TopicArnResolver;
import io.awspring.cloud.sns.core.TopicsListingTopicArnResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
@Import({
        MySQLConfiguration.class,
        TimeSheetReportProducerConfiguration.class,
        TimeTrackingConsumerConfiguration.class,
        TimeSheetRequestConsumerConfiguration.class,
        TimeSheetReportS3Configuration.class
})
public class MainConfiguration {

    @Bean
    public TopicArnResolver topicArnResolver(SnsClient snsClient) {
        return new TopicsListingTopicArnResolver(snsClient);
    }
}
