package com.example.market.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.PagoDTO;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.crud.PagoRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.Pago;
import com.example.market.infraestructure.mapper.PagoMapper;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private PagoMapper pagoMapper;

    public List<PagoDTO> getAll() {
        return pagoRepository.findAll()
                .stream()
                .map(pagoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PagoDTO> getByOrdenId(Long ordenId) {
        return pagoRepository.findByOrdenId(ordenId)
                .stream()
                .map(pagoMapper::toDto)
                .collect(Collectors.toList());
    }

    public PagoDTO save(PagoDTO dto) {
        Orden orden = ordenRepository.findById(dto.getOrdenId())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        // Verifica si el estado actual es "pendiente" y si el pago se realiza
        if ("pendiente".equalsIgnoreCase(orden.getEstado())) {
            orden.setEstado("pagado"); // cambia el estado a "pagado"
            ordenRepository.save(orden); // guarda el cambio
        }

        Pago pago = pagoMapper.toEntity(dto, orden);
        Pago saved = pagoRepository.save(pago);
        return pagoMapper.toDto(saved);
    }

    public PagoDTO update(Long id, PagoDTO dto) {
        dto.setId(id);
        return save(dto);
    }

    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}
