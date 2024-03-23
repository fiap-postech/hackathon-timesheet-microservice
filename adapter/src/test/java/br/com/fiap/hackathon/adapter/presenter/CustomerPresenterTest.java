package br.com.fiap.hackathon.adapter.presenter;

import br.com.fiap.hackathon.adapter.fixture.CustomerFixture;
import br.com.fiap.hackathon.adapter.fixture.Fixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerPresenterTest {

    private CustomerPresenter presenter;

    @BeforeEach
    void setUp() {
        presenter = PresenterFactory.customerPresenter();
    }

    @Test
    void shouldPresentCustomer() {
        var customer = Fixture.create(CustomerFixture.enabledCustomerModel());

        var response = presenter.present(customer);

        assertThat(response.getId()).isEqualTo(customer.uuid().toString());
        assertThat(response.getName()).isEqualTo(customer.name());
        assertThat(response.getEmail()).isEqualTo(customer.email().email());
        assertThat(response.getDocument()).isEqualTo(customer.document().document());
    }
}
