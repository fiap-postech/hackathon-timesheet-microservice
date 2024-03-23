package br.com.fiap.hackathon.adapter.gateway;

import br.com.fiap.hackathon.adapter.gateway.timesheet.TimesheetGatewayFactory;
import br.com.fiap.hackathon.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import br.com.fiap.hackathon.application.gateway.TimeTrackingWriterGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TimeTrackingWriterGatewayTest {

    @Mock
    private TimeSheetWriterRepository writerRepository;

    private TimeTrackingWriterGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = TimesheetGatewayFactory.timeTrackingWriterGateway(writerRepository);
    }

//    @Test
//    void shouldWriteWhenAskedFor() {
//        var customer = create(enabledCustomerModel());
//
//        when(writerRepository.write(any(CustomerDTO.class)))
//                .thenAnswer(i -> Arrays.stream(i.getArguments()).findFirst().orElseThrow());
//
//        var response = gateway.write(customer);
//
//        assertThat(response)
//                .isNotNull()
//                .isEqualTo(customer);
//    }
}
