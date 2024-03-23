package br.com.fiap.hackathon.adapter.controller;

import br.com.fiap.hackathon.adapter.fixture.CustomerDTOFixture;
import br.com.fiap.hackathon.adapter.fixture.Fixture;
import br.com.fiap.hackathon.adapter.presenter.CustomerPresenter;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.CustomerControllerFactory;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.FindCustomerByUUIDController;
import br.com.fiap.hackathon.application.usecase.timesheet.FindCustomerByUUIDUseCase;
import br.com.fiap.tech.challenge.enterprise.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static br.com.fiap.hackathon.adapter.fixture.CustomerFixture.enabledCustomerModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCustomerByUUIDControllerTest {

    @Mock
    private FindCustomerByUUIDUseCase useCase;

    @Mock
    private CustomerPresenter presenter;

    private FindCustomerByUUIDController controller;

    @BeforeEach
    void setUp() {
        controller = CustomerControllerFactory.findCustomerByUUIDController(useCase, presenter);
    }

    @Test
    void shouldReturnCustomerWhenExists() {
        var customer = Fixture.create(enabledCustomerModel());
        var customerDTO = Fixture.create(CustomerDTOFixture.enabledCustomerDTOModel());
        var uuid = customer.uuid();

        when(useCase.get(uuid)).thenReturn(Optional.of(customer));
        when(presenter.present(customer)).thenReturn(customerDTO);

        var response = controller.get(uuid.toString());

        assertThat(response)
                .isNotNull()
                .isPresent()
                .contains(customerDTO);

        verify(useCase).get(uuid);
        verify(presenter).present(customer);
    }

    @Test
    void shouldReturnEmptyWhenNotExists() {
        var uuid = UUID.randomUUID();

        when(useCase.get(uuid)).thenReturn(Optional.empty());

        var uuidText = uuid.toString();

        var response = controller.get(uuidText);

        assertThat(response)
                .isNotNull()
                .isNotPresent();


        verify(useCase).get(uuid);
        verify(presenter, never()).present(any(Customer.class));
    }
}
