package br.com.fiap.tech.challenge.driven.mysql.mapping;

import br.com.fiap.tech.challenge.application.dto.TimeTrackingDTO;
import br.com.fiap.tech.challenge.driven.mysql.model.TimeSheetEntity;
import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBTimeSheetMapper {

    DBTimeSheetMapper INSTANCE = Mappers.getMapper(DBTimeSheetMapper.class);

    CustomerDTO toDTO(TimeSheetEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "lastUpdated", ignore = true)
    @Mapping(target = "version", ignore = true)
    TimeSheetEntity toEntity(TimeTrackingDTO dto);
}
