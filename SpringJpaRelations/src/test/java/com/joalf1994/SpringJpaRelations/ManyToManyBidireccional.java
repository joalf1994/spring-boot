package com.joalf1994.SpringJpaRelations;

import com.joalf1994.SpringJpaRelations.model.Alumno;
import com.joalf1994.SpringJpaRelations.model.Curso;
import com.joalf1994.SpringJpaRelations.model.Profesor;
import com.joalf1994.SpringJpaRelations.repository.AlumnoRepository;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ManyToManyBidireccional {
    @Autowired
    private AlumnoRepository alumnoRepository;


    @Test
    public void insertar() {
        Curso c1 = new Curso("C001", "Base de datos");
        Curso c2 = new Curso("C002", "Algoritmos y programación");
        Curso c3 = new Curso("C003", "Inteligencia artificial");

        List<Curso> cursos = List.of(c1, c2, c3);



        Alumno a1 = new Alumno("A001", "Pedro Varas");
        Alumno a2 = new Alumno("A002", "Pedro Martin");

        a1.setCursos(cursos);
        a2.setCursos(cursos);

        alumnoRepository.save(a1);
        alumnoRepository.save(a2);

        List<Alumno> alumnoList = alumnoRepository.findAll();
        for (Alumno alumno : alumnoList) {
            System.out.println(alumno.getNombre());
            alumno.getCursos().stream().forEach(aux -> System.out.println(aux.getNombre()));
        }

    }
}
