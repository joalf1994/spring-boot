package com.jbobadilla.onetomany.service;

import com.jbobadilla.onetomany.dto.ReservaDto;
import com.jbobadilla.onetomany.model.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IReservaService extends IGenericService<Reserva, Long, ReservaDto> {
    List<ReservaDto> findByHuespedId(Long idHuesped);
}
