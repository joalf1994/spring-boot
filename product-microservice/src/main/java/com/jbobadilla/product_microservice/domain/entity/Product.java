package com.jbobadilla.product_microservice.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String prodName;

    @Column(name = "descripcion")
    private String podDescription;

    @Column(name = "precio_unit")
    private Double unitPrice;
}
