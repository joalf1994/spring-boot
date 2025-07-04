package com.jbobadilla.peliculas.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;

    /*private Genero genero;

    private List<Actor> protagonistas;*/
}
