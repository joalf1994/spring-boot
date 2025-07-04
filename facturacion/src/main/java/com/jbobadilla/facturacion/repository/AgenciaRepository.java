package com.jbobadilla.facturacion.repository;

import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.enums.AgenciaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    Optional<Agencia> findByRuc(String ruc);

    List<Agencia> findByStatus(AgenciaStatus status);
}
