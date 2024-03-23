package br.com.fiap.hackathon.adapter.controller;

import br.com.fiap.hackathon.adapter.fixture.CustomerDTOFixture;
import br.com.fiap.hackathon.adapter.fixture.Fixture;
import br.com.fiap.hackathon.adapter.presenter.CustomerPresenter;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.CustomerControllerFactory;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.UpgradeCustomerController;
import br.com.fiap.hackathon.application.usecase.timesheet.UpgradeCustomerUseCase;
import br.com.fiap.tech.challenge.enterprise.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.fiap.hackathon.adapter.fixture.CustomerFixture.disabledCustomerModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpgradeCustomerControllerTest {

    @Mock
    private UpgradeCustomerUseCase useCase;

    @Mock
    private CustomerPresenter presenter;

    private UpgradeCustomerController controller;

    @BeforeEach
    void setUp() {
        controller = CustomerControllerFactory.upgradeCustomerController(useCase, presenter);
    }

    @Test
    void shouldDisableCustomer() {
        var customer = Fixture.create(disabledCustomerModel());
        var document = "48826325197";
        var customerDTO = Fixture.create(CustomerDTOFixture.disabledCustomerDTOModel());

        when(useCase.disable(document)).thenReturn(Optional.of(customer));
        when(presenter.present(customer)).thenReturn(customerDTO);

        var response = controller.disable(document);

        assertThat(response)
                .isNotNull()
                .isPresent()
                .contains(customerDTO);

        verify(useCase).disable(document);
        verify(presenter).present(customer);
    }

    @Test
    void shouldReturnEmptyWhenAskToDisableCustomerThatNoExists() {
        var document = "48826325197";

        when(useCase.disable(document)).thenReturn(Optional.empty());

        var response = controller.disable(document);

        assertThat(response)
                .isNotNull()
                .isNotPresent();

        verify(useCase).disable(document);
        verify(presenter, never()).present(any(Customer.class));
    }
}
