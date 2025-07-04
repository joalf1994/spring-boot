package com.joalf1994.SpringJpaRelations;

import com.joalf1994.SpringJpaRelations.model.Autor;
import com.joalf1994.SpringJpaRelations.model.Libro;
import com.joalf1994.SpringJpaRelations.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class OneToMany {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void insertar() {
        Libro libro = new Libro("Estructuras de datos");
        Libro libro2 = new Libro("Algoritmos");
        Libro libro3 = new Libro("Bases de datos");

        List<Libro> libros = List.of(libro, libro2, libro3);

        Autor deitel = new Autor("Deitel & Deitel");
        deitel.setLibros(libros);

        autorRepository.save(deitel);

        Optional<Autor> autorDb = autorRepository.findById(deitel.getId());

        if (autorDb.isPresent()) {
            System.out.println("Autor: " + autorDb.get().getNombre());
            System.out.println("Libros: " + autorDb.get().getLibros());
        }


    }
}
