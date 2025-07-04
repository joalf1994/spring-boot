package com.jbobadilla.facturacion.service;

import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.enums.AgenciaStatus;

import java.util.List;

public interface AgenciaService {
    //crud
    Agencia create(Agencia agencia);

    Agencia findById(Long id);

    Agencia update(Long id, Agencia agencia);

    void delete(Long id);

    List<Agencia> findAll();

    Agencia findByRuc(String ruc);

    List<Agencia> findByStatus(AgenciaStatus agenciaStatus);

    Agencia changeStatus(Long id, AgenciaStatus agenciaStatus);
}
