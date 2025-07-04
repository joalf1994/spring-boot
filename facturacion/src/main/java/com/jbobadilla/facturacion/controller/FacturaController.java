package com.jbobadilla.facturacion.controller;

import com.jbobadilla.facturacion.domain.entity.Agencia;
import com.jbobadilla.facturacion.domain.entity.Factura;
import com.jbobadilla.facturacion.service.AgenciaService;
import com.jbobadilla.facturacion.service.ClienteService;
import com.jbobadilla.facturacion.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping("/")
    public ResponseEntity<Factura> addFactura(@RequestBody Factura factura) {
        Factura fact = facturaService.create(factura);
        return ResponseEntity.ok(fact);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Factura> findById(@PathVariable Long id) {
        Factura fact = facturaService.findById(id);
        return ResponseEntity.ok(fact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        Factura fact = facturaService.update(id, factura);
        return ResponseEntity.ok(fact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
        facturaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Factura>> findAll() {
        List<Factura> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/nro-fact/{nroFactura}")
    public ResponseEntity<Factura> findByNroFactura(@PathVariable String nroFactura) {
        Factura factura = facturaService.findByNroFactura(nroFactura);
        return ResponseEntity.ok(factura);
    }



}
