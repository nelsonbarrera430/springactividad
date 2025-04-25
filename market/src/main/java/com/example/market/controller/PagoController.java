package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.PagoDTO;
import com.example.market.domain.service.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    
    @GetMapping
    public List<PagoDTO> getAll() {
        return pagoService.getAll();
    }

    @GetMapping("/orden/{ordenId}")
    public List<PagoDTO> getByOrdenId(@PathVariable Long ordenId) {
        return pagoService.getByOrdenId(ordenId);
    }

   
    @PostMapping
    public PagoDTO save(@RequestBody PagoDTO dto) {
        return pagoService.save(dto);
    }

  
    @PutMapping("/{id}")
    public PagoDTO update(@PathVariable Long id, @RequestBody PagoDTO dto) {
        return pagoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagoService.delete(id);
    }
}
