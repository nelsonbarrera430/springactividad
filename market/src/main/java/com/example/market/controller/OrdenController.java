package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.OrdenDTO;
import com.example.market.domain.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

   
    @GetMapping
    public List<OrdenDTO> listAll() {
        return ordenService.getAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<OrdenDTO> getOne(@PathVariable Long id) {
        OrdenDTO dto = ordenService.getById(id);
        return dto != null
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    
    @PostMapping
    public ResponseEntity<OrdenDTO> create(@RequestBody OrdenDTO dto) {
        OrdenDTO created = ordenService.save(dto);
        return ResponseEntity.status(201).body(created);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<OrdenDTO> update(
            @PathVariable Long id,
            @RequestBody OrdenDTO dto) {
        OrdenDTO updated = ordenService.update(id, dto);
        return updated != null
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
