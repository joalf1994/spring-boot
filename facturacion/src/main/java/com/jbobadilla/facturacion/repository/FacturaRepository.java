package com.jbobadilla.facturacion.repository;

import com.jbobadilla.facturacion.domain.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    Optional<Factura> findByNroFactura(String nroFactura);
}
