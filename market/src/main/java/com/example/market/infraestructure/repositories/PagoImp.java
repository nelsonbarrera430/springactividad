package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.PagoDTO;
import com.example.market.domain.repository.IPago;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.crud.PagoRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.Pago;
import com.example.market.infraestructure.mapper.PagoMapper;

@Repository
public class PagoImp implements IPago {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public List<PagoDTO> getAll() {
        return pagoRepository.findAll()
                .stream()
                .map(pagoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PagoDTO> getById(Long id) {
        return pagoRepository.findById(id)
                .map(pagoMapper::toDto);
    }

    @Override
    public PagoDTO save(PagoDTO dto) {
        Orden orden = ordenRepository.findById(dto.getOrdenId())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        Pago pago = pagoMapper.toEntity(dto, orden);
        Pago saved = pagoRepository.save(pago);
        return pagoMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}
