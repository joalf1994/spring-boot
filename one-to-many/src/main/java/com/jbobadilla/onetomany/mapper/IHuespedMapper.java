package com.jbobadilla.onetomany.mapper;

import com.jbobadilla.onetomany.dto.HuespedDto;
import com.jbobadilla.onetomany.model.Huesped;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IHuespedMapper {

    HuespedDto toDto(Huesped huesped);
    Huesped toEntity(HuespedDto dto);
}
