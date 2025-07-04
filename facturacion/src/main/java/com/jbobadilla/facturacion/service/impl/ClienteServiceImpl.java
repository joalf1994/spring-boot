package com.jbobadilla.facturacion.service.impl;

import com.jbobadilla.facturacion.domain.entity.Cliente;
import com.jbobadilla.facturacion.repository.ClienteRepository;
import com.jbobadilla.facturacion.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Optional<Cliente> clienteAux = clienteRepository.findById(id);
        if (clienteAux.isPresent()) {
            clienteAux.get().setDni(cliente.getDni());
            clienteAux.get().setNombre(cliente.getNombre());
            clienteAux.get().setApellido(cliente.getApellido());
            return clienteRepository.save(clienteAux.get());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }
}
