package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.gateway.CustomerReaderGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static br.com.fiap.tech.challenge.application.fixture.CustomerFixture.enabledCustomerModel;
import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCustomerByUUIDUseCaseTest {

    @Mock
    private CustomerReaderGateway readerGateway;

    private FindCustomerByUUIDUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = TimeSheetUseCaseFactory.findFindCustomerByUUIDService(readerGateway);
    }

    @Test
    void shouldReturnCustomerWhenExists() {
        var customer = create(enabledCustomerModel());
        var uuid = customer.uuid();

        when(readerGateway.readById(uuid)).thenReturn(Optional.of(customer));

        var response = useCase.get(uuid);

        assertThat(response)
                .isNotNull()
                .isPresent()
                .contains(customer);

        verify(readerGateway).readById(uuid);
    }

    @Test
    void shouldReturnEmptyIfCustomerDoesNotExists() {
        var uuid = UUID.randomUUID();

        when(readerGateway.readById(uuid)).thenReturn(Optional.empty());

        var response = useCase.get(uuid);

        assertThat(response)
                .isNotNull()
                .isNotPresent();

        verify(readerGateway).readById(uuid);
    }
}
