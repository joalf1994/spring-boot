package com.jbobadilla.facturacion.service;

import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {
    //crud
    Cliente create(Cliente cliente);

    Cliente findById(Long id);

    Cliente update(Long id, Cliente cliente);

    void delete(Long id);

    List<Cliente> findAll();

    Cliente findByDni(String dni);
}
