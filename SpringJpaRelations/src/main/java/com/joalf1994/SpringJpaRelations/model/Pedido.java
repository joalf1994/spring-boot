package com.joalf1994.SpringJpaRelations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PEDIDO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NRO_PEDIDO")
    private String nroPedido;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PRECIO")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    public Pedido(String nroPedido, String descripcion, Double precio) {
        this.nroPedido = nroPedido;
        this.descripcion = descripcion;
        this.precio = precio;
    }


}
