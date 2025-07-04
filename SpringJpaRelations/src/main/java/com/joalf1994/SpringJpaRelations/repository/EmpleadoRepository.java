package com.joalf1994.SpringJpaRelations.repository;

import com.joalf1994.SpringJpaRelations.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNombre(String nombre);
}
