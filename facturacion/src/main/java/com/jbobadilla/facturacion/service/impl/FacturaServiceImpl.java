package com.jbobadilla.facturacion.service.impl;

import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.entity.Cliente;
import com.jbobadilla.facturacion.domain.entity.Factura;
import com.jbobadilla.facturacion.repository.AgenciaRepository;
import com.jbobadilla.facturacion.repository.ClienteRepository;
import com.jbobadilla.facturacion.repository.FacturaRepository;
import com.jbobadilla.facturacion.service.FacturaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;
    private final AgenciaRepository agenciaRepository;
    private final ClienteRepository clienteRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository, AgenciaRepository agenciaRepository, ClienteRepository clienteRepository) {
        this.facturaRepository = facturaRepository;
        this.agenciaRepository = agenciaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Factura create(Factura factura) {
        Long agenciaId = factura.getAgencia().getId();
        Long clienteId = factura.getCliente().getId();

        Agencia agencia = agenciaRepository.findById(agenciaId).orElseThrow(() -> new RuntimeException("Agencia no encontrada con ID: " + agenciaId));
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + clienteId));

        factura.setAgencia(agencia);
        factura.setCliente(cliente);

        return facturaRepository.save(factura);
    }

    @Override
    public Factura findById(Long id) {
        return facturaRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada con ID: " + id));
    }

    @Override
    public Factura update(Long id, Factura factura) {
        Factura auxFactura = facturaRepository.findById(id).orElse(null);
        if (auxFactura != null) {
            auxFactura.setNroFactura(factura.getNroFactura());
            auxFactura.setFechaFactura(factura.getFechaFactura());
            auxFactura.setMonto(factura.getMonto());
            return facturaRepository.save(auxFactura);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Factura no encontrada con ID: " + id);
        }
    }

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura findByNroFactura(String nroFactura) {
        return facturaRepository.findByNroFactura(nroFactura).orElseThrow(() -> new RuntimeException("Factura no encontrada con nro: " + nroFactura));
    }
}
