package br.com.fiap.hackathon.launcher.messaging;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.driven.mysql.repository.TimeSheetEntityRepository;
import br.com.fiap.hackathon.launcher.config.TestConfiguration;
import br.com.fiap.hackathon.launcher.fixture.TimeTrackingDTOFixture;
import br.com.fiap.hackathon.launcher.util.QueueUtil;
import br.com.fiap.hackathon.launcher.util.TimeTrackingUtil;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.instancio.Model;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.util.stream.Stream;

import static br.com.fiap.hackathon.launcher.container.DatabaseContainers.localDatabaseContainer;
import static br.com.fiap.hackathon.launcher.container.LocalStackContainers.localStackContainer;
import static br.com.fiap.hackathon.launcher.util.ConfigurationOverrides.overrideConfiguration;
import static org.awaitility.Awaitility.given;
import static org.instancio.Instancio.create;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({ "test" })
@Testcontainers
@DirtiesContext(classMode = AFTER_CLASS)
public class CreateTimeTrackingIT {

    @Container
    protected static final MySQLContainer DATABASE = localDatabaseContainer();

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @Autowired
    private Environment env;

    @Autowired
    private SqsTemplate sqsTemplate;

    @Autowired
    private TimeSheetEntityRepository repository;

    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        overrideConfiguration(registry, DATABASE, LOCAL_STACK_CONTAINER);
    }

    @ParameterizedTest
    @MethodSource("getCreateOptions")
    void testCreatePayment(Model<TimeTrackingDTO> model) {
        var message = create(model);

        QueueUtil.sendMessage(sqsTemplate, TimeTrackingUtil.getTimeTrackingEventQueueName(env), message);

        given()
                .await()
                .pollInterval(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(50))
                .ignoreExceptions()
                .untilAsserted(() -> {
                    var timeSheetEntityOpt = repository.findByEmployeeIdAndDateAndUuidEndRecordIsNull(message.getEmployeeId(), message.getDate());
                    assertTrue(timeSheetEntityOpt.isPresent());
                });
    }

    static Stream<Model<TimeTrackingDTO>> getCreateOptions() {
        return Stream.of(
                TimeTrackingDTOFixture.TimeTrackingDTOModel()
        );
    }

}
