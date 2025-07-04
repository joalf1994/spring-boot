package com.joalf1994.SpringJpaRelations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DIRECCION")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Direccion {

    @Id
    @Column(name = "DIRECCION_ID")
    private Long id;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "LOCALIDAD")
    private String localidad;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "PAIS")
    private String pais;
}
