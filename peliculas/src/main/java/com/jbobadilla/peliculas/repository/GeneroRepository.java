package com.jbobadilla.peliculas.repository;

import com.jbobadilla.peliculas.domain.entity.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {
}
