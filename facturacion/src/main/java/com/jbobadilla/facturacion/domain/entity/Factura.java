package com.jbobadilla.facturacion.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "FACTURA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nro_factura", nullable = false, length = 25)
    private String nroFactura;

    @Column(name = "fecha_factura", nullable = false)
    private Date fechaFactura;

    @Column(name = "monto", nullable = false)
    private double monto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "cliente-factura")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agencia_id")
    @JsonBackReference(value = "agencia-factura")
    private Agencia agencia;

}
