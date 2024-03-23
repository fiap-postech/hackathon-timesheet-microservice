package br.com.fiap.hackathon.launcher.container;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DatabaseContainers {

    public static MySQLContainer<?> localDatabaseContainer(){
        return new MySQLContainer<>(DockerImageName.parse("mysql:8.0"))
                .withDatabaseName("timesheetdb")
                .withUsername("sys_hackathon_timesheet")
                .withPassword("hackathon_timesheet_6#233zJMNTjkQb#sgps#");
    }

}
