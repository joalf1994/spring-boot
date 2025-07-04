package com.jbobadilla.facturacion.controller;

import com.jbobadilla.facturacion.domain.dto.StatusDTO;
import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.enums.AgenciaStatus;
import com.jbobadilla.facturacion.service.AgenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/agencia")
public class AgenciaController {

    private final AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    @PostMapping("/")
    public ResponseEntity<Agencia> addAgencia(@RequestBody Agencia agencia) {
        Agencia aux = agenciaService.create(agencia);
        return ResponseEntity.ok(aux);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Agencia> findById(@PathVariable Long id) {
        Agencia aux = agenciaService.findById(id);
        return ResponseEntity.ok(aux);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agencia> update(@PathVariable Long id, @RequestBody Agencia agencia) {
        Agencia aux = agenciaService.update(id, agencia);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Agencia>> findAll() {
        List<Agencia> list = agenciaService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/ruc/{ruc}")
    public ResponseEntity<Agencia> findByRuc(@PathVariable String ruc) {
        Agencia aux = agenciaService.findByRuc(ruc);
        return ResponseEntity.ok(aux);
    }

    @GetMapping("/status/{agenciaStatus}")
    public ResponseEntity<List<Agencia>> findByStatus(@PathVariable AgenciaStatus agenciaStatus) {
        List<Agencia> agenciaList = agenciaService.findByStatus(agenciaStatus);
        return ResponseEntity.ok(agenciaList);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Agencia> changeStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        Agencia aux = agenciaService.changeStatus(id, statusDTO.getStatus());
        return ResponseEntity.ok(aux);
    }


}
