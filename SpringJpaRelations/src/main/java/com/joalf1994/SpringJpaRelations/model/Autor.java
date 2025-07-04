package com.joalf1994.SpringJpaRelations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "AUTOR")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTOR_ID")
    private List<Libro> libros;

    public Autor(String nombre) {
        this.nombre = nombre;
    }
}
