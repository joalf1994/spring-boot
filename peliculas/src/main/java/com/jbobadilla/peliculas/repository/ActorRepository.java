package com.jbobadilla.peliculas.repository;

import com.jbobadilla.peliculas.domain.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
}
