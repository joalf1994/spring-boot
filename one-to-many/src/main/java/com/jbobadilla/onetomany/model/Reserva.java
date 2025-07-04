package com.jbobadilla.onetomany.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_entrada")
    private LocalDate fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "forma_pago")
    private String formaPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "huesped_id",  nullable = false)
    private Huesped huesped;


}
