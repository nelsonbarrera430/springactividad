package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.PagoDTO;

public interface IPago {
    List<PagoDTO> getAll();
    Optional<PagoDTO> getById(Long id);
    PagoDTO save(PagoDTO dto);
    void delete(Long id);
}
