package br.com.fiap.tech.challenge.driven.mysql.mapping;

import br.com.fiap.tech.challenge.application.dto.DataRemovalDTO;
import br.com.fiap.tech.challenge.application.dto.TimeTrackingReportDTO;
import br.com.fiap.tech.challenge.driven.mysql.model.TimeSheetEntity;
import br.com.fiap.tech.challenge.driven.mysql.model.DataRemovalEntity;
import br.com.fiap.tech.challenge.driven.mysql.model.DataRemovalItem;
import br.com.fiap.tech.challenge.driven.mysql.repository.TimeSheetEntityRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class DBDataRemovalMapper {

    @Autowired
    private TimeSheetEntityRepository customerRepository;


    public abstract DataRemovalDTO toDTO(DataRemovalEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", source = "customerId", qualifiedByName = "getCustomerEntity")
    public abstract DataRemovalEntity toEntity(DataRemovalDTO dto);

    public abstract TimeTrackingReportDTO toDTO(DataRemovalItem item);

    public abstract DataRemovalItem toEntity(TimeTrackingReportDTO dto);

    @Named("getCustomerEntity")
    TimeSheetEntity getCustomerEntity(String id) {
        return null;
    }


}
