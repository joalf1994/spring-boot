package com.joalf1994.SpringJpaRelations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LIBRO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    public Libro(String titulo) {
        this.titulo = titulo;
    }
}
