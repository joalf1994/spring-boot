package com.jbobadilla.facturacion.service.impl;

import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.enums.AgenciaStatus;
import com.jbobadilla.facturacion.repository.AgenciaRepository;
import com.jbobadilla.facturacion.service.AgenciaService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public Agencia create(Agencia agencia) {
        return agenciaRepository.save(agencia);
    }

    @Override
    public Agencia findById(Long id) {
        return agenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agencia no encontrada"));
    }

    @Override
    public Agencia update(Long id, Agencia agencia) {
        Optional<Agencia> auxAgencia = agenciaRepository.findById(id);
        if (auxAgencia.isPresent()) {
            auxAgencia.get().setRuc(agencia.getRuc());
            auxAgencia.get().setRazonSocial(agencia.getRazonSocial());
            auxAgencia.get().setStatus(agencia.getStatus());
            return agenciaRepository.save(auxAgencia.get());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Agencia agencia = findById(id);

        if (!agencia.getFacturas().isEmpty()) {
            throw new RuntimeException("No se puede eliminar la agencia xq tiene facturas asociadas");
        }
        agenciaRepository.deleteById(id);
    }

    @Override
    public List<Agencia> findAll() {
        return agenciaRepository.findAll();
    }

    @Override
    public Agencia findByRuc(String ruc) {
        return agenciaRepository.findByRuc(ruc).orElse(null);
    }

    @Override
    public List<Agencia> findByStatus(AgenciaStatus agenciaStatus) {
        return agenciaRepository.findByStatus(agenciaStatus);
    }

    public Agencia changeStatus(Long id, AgenciaStatus agenciaStatus) {
        Agencia auxAgencia = findById(id);

        auxAgencia.setStatus(agenciaStatus);
        return agenciaRepository.save(auxAgencia);

    }
}
