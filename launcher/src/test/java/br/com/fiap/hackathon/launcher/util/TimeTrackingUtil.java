package br.com.fiap.hackathon.launcher.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeTrackingUtil {

    public static String getTimeTrackingEventQueueName(Environment env) {
        return env.getProperty("aws.resources.sqs.time-tracking-event.queue");
    }
}
