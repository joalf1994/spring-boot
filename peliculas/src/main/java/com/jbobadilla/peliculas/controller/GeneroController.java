package com.jbobadilla.peliculas.controller;

import com.jbobadilla.peliculas.domain.entity.Genero;
import com.jbobadilla.peliculas.service.GeneroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public Long save(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoService.save(genero);
        return genero.getId();
    }

    @GetMapping("/{id}")
    public String findById(Long id) {
        return generoService.findById(id).getNombre();
    }

    /*public void delete(Long id);
    public List<Genero> findAll();*/
}
