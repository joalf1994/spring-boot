package com.joalf1994.SpringJpaRelations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "PASAPORTE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pasaporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "FECHA_EMISION")
    private LocalDate fEmision;

    @Column(name = "FECHA_EXPIRACION")
    private LocalDate fExpiracion;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pasaporte")
    private Empleado empleado;
}
