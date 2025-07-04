package com.jbobadilla.onetomany.service.impl;

import com.jbobadilla.onetomany.dto.HuespedDto;
import com.jbobadilla.onetomany.exception.ExceptionHandlerDto;
import com.jbobadilla.onetomany.exception.NotFoundException;
import com.jbobadilla.onetomany.mapper.IHuespedMapper;
import com.jbobadilla.onetomany.model.Huesped;
import com.jbobadilla.onetomany.repository.IHuespedRepository;
import com.jbobadilla.onetomany.service.IHuespedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HuespedServiceImpl implements IHuespedService {

    private final IHuespedRepository huespedRepository;
    private final IHuespedMapper huespedMapper;

    public HuespedServiceImpl(IHuespedRepository huespedRepository, IHuespedMapper huespedMapper) {
        this.huespedRepository = huespedRepository;
        this.huespedMapper = huespedMapper;
    }

    @Override
    public List<HuespedDto> findAll() {
        return huespedRepository.findAll()
                .stream()
                .map(huespedMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HuespedDto findById(Long id) {
        Huesped huesped = huespedRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Huésped con ID " + id + " no encontrado"));
        return huespedMapper.toDto(huesped);
    }

    @Override
    public HuespedDto save(HuespedDto huespedDto) {
        Huesped huesped = huespedMapper.toEntity(huespedDto);
        Huesped saved = huespedRepository.save(huesped);
        return huespedMapper.toDto(saved);
    }

    @Override
    public HuespedDto update(Long id, HuespedDto huespedDto) {
        Huesped huespedb = huespedRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Huésped con ID " + id + " no encontrado"));

        huespedb.setNombre(huespedDto.getNombre());
        huespedb.setApellido(huespedDto.getApellido());
        huespedb.setTelefono(huespedDto.getTelefono());
        huespedb.setNacionalidad(huespedDto.getNacionalidad());
        huespedb.setFechaNacimiento(huespedDto.getFechaNacimiento());

        Huesped saved =  huespedRepository.save(huespedb);
        return  huespedMapper.toDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        if (!huespedRepository.existsById(id)) {
            throw new NotFoundException("Huésped con ID " + id + " no encontrado");
        }
        huespedRepository.deleteById(id);
    }
}