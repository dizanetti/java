package com.labmapstruct.domain;

import com.labmapstruct.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "address", target = "addressList")
    @Mapping(source = "id", target = "identification")
    PersonDto personToPersonDto(Person person);
}
