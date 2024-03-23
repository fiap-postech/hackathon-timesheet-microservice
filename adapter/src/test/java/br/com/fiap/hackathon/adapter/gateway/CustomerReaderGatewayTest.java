package br.com.fiap.hackathon.adapter.gateway;

import br.com.fiap.hackathon.adapter.fixture.CustomerDTOFixture;
import br.com.fiap.hackathon.adapter.fixture.CustomerFixture;
import br.com.fiap.hackathon.adapter.fixture.Fixture;
import br.com.fiap.hackathon.adapter.gateway.timesheet.TimesheetGatewayFactory;
import br.com.fiap.hackathon.adapter.repository.CustomerReaderRepository;
import br.com.fiap.hackathon.application.gateway.CustomerReaderGateway;
import br.com.fiap.tech.challenge.enterprise.valueobject.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerReaderGatewayTest {

    @Mock
    private CustomerReaderRepository repository;

    private CustomerReaderGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = TimesheetGatewayFactory.customerReaderGateway(repository);
    }

    @Nested
    class FindCustomerByUUID {
        @Test
        void shouldReturnCustomerWhenExists() {
            var customerDTO = Fixture.create(CustomerDTOFixture.enabledCustomerDTOModel());
            var customer = Fixture.create(CustomerFixture.enabledCustomerModel());
            var uuid = customer.uuid();

            when(repository.readById(uuid.toString())).thenReturn(Optional.of(customerDTO));

            var response = gateway.readById(uuid);

            assertThat(response)
                    .isNotNull()
                    .isPresent()
                    .contains(customer);

            verify(repository).readById(uuid.toString());
        }

        @Test
        void shouldReturnEmptyWhenCustomerDoesNotExists() {
            var uuid = UUID.randomUUID();
            var uuidText = uuid.toString();

            when(repository.readById(uuid.toString())).thenReturn(Optional.empty());

            var response = gateway.readById(uuid);

            assertThat(response)
                    .isNotNull()
                    .isNotPresent();

            verify(repository).readById(uuid.toString());
        }
    }

    @Nested
    class FindCustomerByDocument {

        @Test
        void shouldReturnCustomerWhenExists() {
            var customerDTO = Fixture.create(CustomerDTOFixture.enabledCustomerDTOModel());
            var customer = Fixture.create(CustomerFixture.enabledCustomerModel());
            var document = customer.document();

            when(repository.readByDocument(document.document())).thenReturn(Optional.of(customerDTO));

            var response = gateway.readByDocument(document);

            assertThat(response)
                    .isNotNull()
                    .isPresent()
                    .contains(customer);

            verify(repository).readByDocument(document.document());
        }

        @Test
        void shouldReturnEmptyWhenCustomerDoesNotExists() {
            var document = Document.of("48826325197");

            when(repository.readByDocument(document.document())).thenReturn(Optional.empty());

            var response = gateway.readByDocument(document);

            assertThat(response)
                    .isNotNull()
                    .isNotPresent();

            verify(repository).readByDocument(document.document());
        }
    }
}
