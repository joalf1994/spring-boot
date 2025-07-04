package com.jbobadilla.onetomany.controller;

import com.jbobadilla.onetomany.dto.HuespedDto;
import com.jbobadilla.onetomany.service.IHuespedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HuespedController {

    private final IHuespedService huespedService;

    public HuespedController(IHuespedService huespedService) {
        this.huespedService = huespedService;
    }

    @GetMapping(value = "/huespedes")
    public ResponseEntity<List<HuespedDto>> getAllHuespedes() {
        return ResponseEntity.ok(huespedService.findAll());
    }

    @GetMapping("/huespedes/{id}")
    public ResponseEntity<HuespedDto> findHuespedById(@PathVariable Long id) {
        return ResponseEntity.ok(huespedService.findById(id));
    }

    @PostMapping(value = "/huesped")
    public ResponseEntity<HuespedDto> createHuesped (@RequestBody HuespedDto requestDto) {
        HuespedDto createdDto = huespedService.save(requestDto);
        URI uri = URI.create("/api/v1/huesped/"+createdDto.getId());
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping(value = "/huespedes/{id}")
    public ResponseEntity<HuespedDto> updateHuesped(@PathVariable Long id, @RequestBody HuespedDto huespedDto) {
        return  ResponseEntity.ok(huespedService.update(id, huespedDto));
    }

    @DeleteMapping("/huespedes/{id}")
    public ResponseEntity<Void> deleteHuespedById(@PathVariable Long id) {
        huespedService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
