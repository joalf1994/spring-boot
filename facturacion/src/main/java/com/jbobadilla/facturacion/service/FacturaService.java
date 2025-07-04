package com.jbobadilla.facturacion.service;

import com.jbobadilla.facturacion.domain.entity.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    //crud
    Factura create(Factura factura);

    Factura findById(Long id);

    Factura update(Long id, Factura factura);

    void delete(Long id);

    List<Factura> findAll();

    Factura findByNroFactura(String nroFactura);
}
