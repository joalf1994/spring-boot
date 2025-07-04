package com.jbobadilla.peliculas.service;

import com.jbobadilla.peliculas.domain.entity.Genero;

import java.util.List;

public interface GeneroService {
    public void save(Genero genero);
    public Genero findById(Long id);
    public void delete(Long id);
    public List<Genero> findAll();
}
