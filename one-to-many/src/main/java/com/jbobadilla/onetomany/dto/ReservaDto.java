package com.jbobadilla.onetomany.dto;

import com.jbobadilla.onetomany.model.Huesped;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaDto {

    private Long id;

    private LocalDate fechaEntrada;

    private LocalDate fechaSalida;

    private Double valor;

    private String formaPago;

    private Long huespedId;
}
