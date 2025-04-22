package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.OrdenDTO;
import com.example.market.infraestructure.entity.Orden;

public interface IOrden {
    List<OrdenDTO> getAll();
    Optional<OrdenDTO> getById(Long id);
    OrdenDTO save(OrdenDTO ordenDTO);
    void delete(Long id);

    Orden saveEntity(Orden orden);
}
