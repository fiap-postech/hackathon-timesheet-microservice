package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.enterprise.entity.Customer;
import br.com.fiap.tech.challenge.enterprise.valueobject.Document;
import br.com.fiap.tech.challenge.application.gateway.CustomerReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.TimeTrackingWriterGateway;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
class UpgradeCustomerUseCaseImpl implements UpgradeCustomerUseCase {

    private final TimeTrackingWriterGateway writerGateway;
    private final CustomerReaderGateway readerGateway;

    @Override
    public Optional<Customer> disable(String document) {
        return Optional.empty();
    }
}
