package com.jbobadilla.onetomany.repository;

import com.jbobadilla.onetomany.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHuespedRepository extends JpaRepository<Huesped,Long> {
    List<Huesped> findByNombreContainingIgnoreCase(String nombre);
}
