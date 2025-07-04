package com.jbobadilla.facturacion.controller;

import com.jbobadilla.facturacion.domain.entity.Cliente;
import com.jbobadilla.facturacion.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.create(cliente));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente aux = clienteService.update(id, cliente);
        return ResponseEntity.ok(aux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clienteList = clienteService.findAll();
        return ResponseEntity.ok(clienteList);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Cliente> getClienteByDni(@PathVariable String dni) {
        Cliente cliente = clienteService.findByDni(dni);
        return ResponseEntity.ok(cliente);
    }


}
