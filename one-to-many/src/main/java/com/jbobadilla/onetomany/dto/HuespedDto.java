package com.jbobadilla.onetomany.dto;

import com.jbobadilla.onetomany.model.Reserva;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HuespedDto {
    private Long id;

    private String nombre;

    private String apellido;

    private LocalDate fechaNacimiento;

    private String nacionalidad;

    private String telefono;
}
