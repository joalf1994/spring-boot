package com.jbobadilla.onetomany.mapper;

import com.jbobadilla.onetomany.dto.ReservaDto;
import com.jbobadilla.onetomany.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IReservaMapper {

    @Mapping(source = "huesped.id", target = "huespedId")
    ReservaDto toDto(Reserva reserva);

    @Mapping(source = "huespedId", target = "huesped.id")
    Reserva toEntity(ReservaDto dto);

}
