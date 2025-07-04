package com.jbobadilla.onetomany.controller;

import com.jbobadilla.onetomany.dto.HuespedDto;
import com.jbobadilla.onetomany.dto.ReservaDto;
import com.jbobadilla.onetomany.service.IReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservaController {

    private final IReservaService reservaService;

    public ReservaController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/reservas")
    public ResponseEntity<List<ReservaDto>> findAllReservas() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservaDto> findReservaById(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @PostMapping("/reserva")
    public ResponseEntity<ReservaDto> createReserva(@RequestBody ReservaDto requestDto) {
        ReservaDto reservaDto = reservaService.save(requestDto);
        URI uri = URI.create("/api/v1/reserva/"+reservaDto.getId());
        return ResponseEntity.created(uri).body(reservaDto);
    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<ReservaDto> updateReserva(@PathVariable Long id, @RequestBody ReservaDto requestDto) {
        return ResponseEntity.ok(reservaService.update(id, requestDto));
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/huespedes/{id}/reservas")
    public ResponseEntity<List<ReservaDto>> findReservasByHuespedId(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findByHuespedId(id));
    }

}

