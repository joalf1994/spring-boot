package com.jbobadilla.peliculas.service.impl;

import com.jbobadilla.peliculas.domain.entity.Genero;
import com.jbobadilla.peliculas.repository.GeneroRepository;
import com.jbobadilla.peliculas.service.GeneroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public void save(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        generoRepository.deleteById(id);
    }

    @Override
    public List<Genero> findAll() {
        return (List<Genero>)generoRepository.findAll();
    }
}
