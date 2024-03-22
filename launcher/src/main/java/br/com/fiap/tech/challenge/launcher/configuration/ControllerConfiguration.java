package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.controller.customer.CreateCustomerController;
import br.com.fiap.tech.challenge.adapter.controller.customer.CustomerControllerFactory;
import br.com.fiap.tech.challenge.adapter.controller.customer.FindCustomerByDocumentController;
import br.com.fiap.tech.challenge.adapter.controller.customer.FindCustomerByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.customer.FindDataRemovalByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.customer.TimeTrackingController;
import br.com.fiap.tech.challenge.adapter.controller.customer.RequestDataRemovalController;
import br.com.fiap.tech.challenge.adapter.controller.customer.UpdateDataRemovalController;
import br.com.fiap.tech.challenge.adapter.controller.customer.UpgradeCustomerController;
import br.com.fiap.tech.challenge.adapter.presenter.CustomerPresenter;
import br.com.fiap.tech.challenge.adapter.presenter.DataRemovalPresenter;
import br.com.fiap.tech.challenge.application.usecase.customer.CreateCustomerUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.FindCustomerByDocumentUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.FindCustomerByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.FindDataRemovalByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.PublishDataRemovalUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.TimeTrackingUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.RequestDataRemovalUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.UpdateDataRemovalUseCase;
import br.com.fiap.tech.challenge.application.usecase.customer.UpgradeCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public CreateCustomerController createCustomerController(CreateCustomerUseCase useCase, CustomerPresenter presenter) {
        return CustomerControllerFactory.createCustomerController(useCase, presenter);
    }

    @Bean
    public FindCustomerByDocumentController findCustomerByDocumentController(FindCustomerByDocumentUseCase useCase, CustomerPresenter presenter) {
        return CustomerControllerFactory.findCustomerByDocumentController(useCase, presenter);
    }

    @Bean
    public FindCustomerByUUIDController findCustomerByUUIDController(FindCustomerByUUIDUseCase useCase, CustomerPresenter presenter) {
        return CustomerControllerFactory.findCustomerByUUIDController(useCase, presenter);
    }

    @Bean
    public UpgradeCustomerController upgradeCustomerController(UpgradeCustomerUseCase useCase, CustomerPresenter presenter) {
        return CustomerControllerFactory.upgradeCustomerController(useCase, presenter);
    }

    @Bean
    public RequestDataRemovalController requestDataRemovalController(RequestDataRemovalUseCase removalUseCase, PublishDataRemovalUseCase publishUseCase, DataRemovalPresenter presenter) {
        return CustomerControllerFactory.requestDataRemovalController(removalUseCase, publishUseCase, presenter);
    }

    @Bean
    public FindDataRemovalByUUIDController findDataRemovalByUUIDController(FindDataRemovalByUUIDUseCase useCase, DataRemovalPresenter presenter) {
        return CustomerControllerFactory.findDataRemovalByUUIDController(useCase, presenter);
    }

    @Bean
    public TimeTrackingController removeDataController(TimeTrackingUseCase useCase) {
        return CustomerControllerFactory.removeDataController(useCase);
    }

    @Bean
    public UpdateDataRemovalController updateDataRemovalController(UpdateDataRemovalUseCase useCase) {
        return CustomerControllerFactory.updateDataRemovalController(useCase);
    }
}
