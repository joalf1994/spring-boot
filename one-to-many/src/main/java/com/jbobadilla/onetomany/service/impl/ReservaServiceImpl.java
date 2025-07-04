package com.jbobadilla.onetomany.service.impl;

import com.jbobadilla.onetomany.dto.ReservaDto;
import com.jbobadilla.onetomany.exception.ExceptionHandlerDto;
import com.jbobadilla.onetomany.exception.NotFoundException;
import com.jbobadilla.onetomany.mapper.IReservaMapper;
import com.jbobadilla.onetomany.model.Reserva;
import com.jbobadilla.onetomany.repository.IReservaRepository;
import com.jbobadilla.onetomany.service.IReservaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements IReservaService {

    private final IReservaRepository reservaRepository;
    private final IReservaMapper reservaMapper;

    public ReservaServiceImpl(IReservaRepository reservaRepository, IReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public List<ReservaDto> findAll() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDto findById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrado"));
        return reservaMapper.toDto(reserva);
    }

    @Override
    public ReservaDto save(ReservaDto requestDto) {
        Reserva reserva = reservaMapper.toEntity(requestDto);
        return reservaMapper.toDto(reservaRepository.save(reserva));
    }

    @Override
    public ReservaDto update(Long id, ReservaDto requestDto) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva no encontrado"));
        requestDto.setId(id);
        return reservaMapper.toDto(reservaRepository.save(reservaMapper.toEntity(requestDto)));

    }

    @Override
    public void deleteById(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new RuntimeException("Reserva con " + id + " no encontrada");
        }
        reservaRepository.deleteById(id);
    }

    @Override
    public List<ReservaDto> findByHuespedId(Long idHuesped) {
        return reservaRepository.findByHuesped_Id(idHuesped)
                .stream()
                .map(reservaMapper::toDto)
                .collect(Collectors.toList());
    }
}
