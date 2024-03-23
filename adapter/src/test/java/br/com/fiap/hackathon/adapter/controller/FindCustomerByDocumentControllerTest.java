package br.com.fiap.hackathon.adapter.controller;

import br.com.fiap.hackathon.adapter.fixture.CustomerDTOFixture;
import br.com.fiap.hackathon.adapter.fixture.Fixture;
import br.com.fiap.hackathon.adapter.presenter.CustomerPresenter;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.CustomerControllerFactory;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.FindCustomerByDocumentController;
import br.com.fiap.hackathon.application.usecase.timesheet.FindCustomerByDocumentUseCase;
import br.com.fiap.tech.challenge.enterprise.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.fiap.hackathon.adapter.fixture.CustomerFixture.enabledCustomerModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCustomerByDocumentControllerTest {

    @Mock
    private FindCustomerByDocumentUseCase useCase;

    @Mock
    private CustomerPresenter presenter;

    private FindCustomerByDocumentController controller;

    @BeforeEach
    void setUp() {
        controller = CustomerControllerFactory.findCustomerByDocumentController(useCase, presenter);
    }

    @Test
    void shouldReturnCustomerWhenExists() {
        var customer = Fixture.create(enabledCustomerModel());
        var customerDTO = Fixture.create(CustomerDTOFixture.enabledCustomerDTOModel());

        when(useCase.get(any(String.class))).thenReturn(Optional.of(customer));
        when(presenter.present(customer)).thenReturn(customerDTO);

        var response = controller.get("48826325197");

        assertThat(response)
                .isNotNull()
                .isPresent()
                .contains(customerDTO);

        verify(useCase).get(any(String.class));
        verify(presenter).present(customer);
    }

    @Test
    void shouldReturnEmptyWhenNotExists() {
        when(useCase.get(any(String.class))).thenReturn(Optional.empty());

        var response = controller.get("48826325197");

        assertThat(response)
                .isNotNull()
                .isNotPresent();

        verify(useCase).get(any(String.class));
        verify(presenter, never()).present(any(Customer.class));
    }
}
