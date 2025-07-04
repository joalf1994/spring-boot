package com.joalf1994.SpringJpaRelations;

import com.joalf1994.SpringJpaRelations.model.Curso;
import com.joalf1994.SpringJpaRelations.model.Profesor;
import com.joalf1994.SpringJpaRelations.repository.ProfesorREpository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class ManyToMany {

    //relacion de muchos a muchos entre profesor y curso
    private ProfesorREpository profesorREpository;

    @Test
    public void insertar() {
        Curso c1 = new Curso("C001", "Base de datos");
        Curso c2 = new Curso("C002", "Algoritmos y programación");
        Curso c3 = new Curso("C003", "Inteligencia artificial");

        List<Curso> cursos = List.of(c1, c2, c3);

        Profesor profesor = new Profesor("Jorge Vigo");
        profesor.setCursos(cursos);

        profesorREpository.save(profesor);

        List<Profesor> profesores = profesorREpository.findAll();
        for (Profesor profesor1 : profesores) {
            System.out.println(profesor1);
        }
    }
}
