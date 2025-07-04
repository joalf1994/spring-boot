package com.joalf1994.SpringJpaRelations.repository;

import com.joalf1994.SpringJpaRelations.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
