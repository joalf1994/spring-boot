package com.jbobadilla.facturacion.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String dni;

    private String nombre;

    private String apellido;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonManagedReference(value = "cliente-factura")
    private List<Factura> facturas;
}
