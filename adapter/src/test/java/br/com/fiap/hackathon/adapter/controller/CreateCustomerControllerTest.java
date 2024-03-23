package br.com.fiap.hackathon.adapter.controller;

import br.com.fiap.hackathon.adapter.fixture.CreateCustomerDTOFixture;
import br.com.fiap.hackathon.adapter.fixture.CustomerDTOFixture;
import br.com.fiap.hackathon.adapter.fixture.Fixture;
import br.com.fiap.hackathon.adapter.presenter.CustomerPresenter;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.CreateCustomerController;
import br.com.fiap.tech.challenge.adapter.controller.timesheet.CustomerControllerFactory;
import br.com.fiap.hackathon.application.usecase.timesheet.CreateCustomerUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.fiap.hackathon.adapter.fixture.CustomerFixture.enabledCustomerModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateCustomerControllerTest {

    @Mock
    private CreateCustomerUseCase useCase;

    @Mock
    private CustomerPresenter presenter;

    private CreateCustomerController controller;

    @BeforeEach
    void setUp(){
        controller = CustomerControllerFactory.createCustomerController(useCase, presenter);
    }

    @Test
    void shouldCreateCustomer() {
        var createCustomerDTO = Fixture.create(CreateCustomerDTOFixture.createCustomerDTOModel());
        var customer = Fixture.create(enabledCustomerModel());
        var customerDTO = Fixture.create(CustomerDTOFixture.enabledCustomerDTOModel());

        when(useCase.create(createCustomerDTO)).thenReturn(customer);
        when(presenter.present(customer)).thenReturn(customerDTO);

        var response = controller.create(createCustomerDTO);

        assertThat(response)
                .isNotNull()
                .isEqualTo(customerDTO);

        verify(useCase).create(createCustomerDTO);
        verify(presenter).present(customer);
    }


}
