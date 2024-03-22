package br.com.fiap.tech.challenge.adapter.gateway;

import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import br.com.fiap.tech.challenge.adapter.gateway.customer.CustomerGatewayFactory;
import br.com.fiap.tech.challenge.adapter.repository.TimeSheetWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static br.com.fiap.tech.challenge.adapter.fixture.CustomerFixture.enabledCustomerModel;
import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimeTrackingWriterGatewayTest {

    @Mock
    private TimeSheetWriterRepository writerRepository;

    private TimeTrackingWriterGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = CustomerGatewayFactory.customerWriterGateway(writerRepository);
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
