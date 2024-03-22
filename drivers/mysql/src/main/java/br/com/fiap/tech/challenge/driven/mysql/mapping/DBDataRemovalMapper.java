package br.com.fiap.tech.challenge.driven.mysql.mapping;

import br.com.fiap.tech.challenge.application.dto.DataRemovalDTO;
import br.com.fiap.tech.challenge.application.dto.DataRemovalItemDTO;
import br.com.fiap.tech.challenge.driven.mysql.model.TimeSheetEntity;
import br.com.fiap.tech.challenge.driven.mysql.model.DataRemovalEntity;
import br.com.fiap.tech.challenge.driven.mysql.model.DataRemovalItem;
import br.com.fiap.tech.challenge.driven.mysql.repository.TimeSheetEntityRepository;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.CUSTOMER_NOT_FOUND;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class DBDataRemovalMapper {

    @Autowired
    private TimeSheetEntityRepository customerRepository;


    public abstract DataRemovalDTO toDTO(DataRemovalEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", source = "customerId", qualifiedByName = "getCustomerEntity")
    public abstract DataRemovalEntity toEntity(DataRemovalDTO dto);

    public abstract DataRemovalItemDTO toDTO(DataRemovalItem item);

    @Mapping(target = "uuid", source = "id")
    public abstract DataRemovalItem toEntity(DataRemovalItemDTO dto);

    @Named("getCustomerEntity")
    TimeSheetEntity getCustomerEntity(String id) {
        return null;
    }


}
