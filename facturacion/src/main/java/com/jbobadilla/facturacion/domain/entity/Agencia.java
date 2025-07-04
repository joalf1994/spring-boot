package com.jbobadilla.facturacion.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jbobadilla.facturacion.domain.enums.AgenciaStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "AGENCIA")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruc", nullable = false, unique = true, length = 11)
    private String ruc;

    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @Enumerated(EnumType.STRING)
    private AgenciaStatus status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agencia")
    @JsonManagedReference(value = "agencia-factura")
    private List<Factura> facturas;
}
