package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.ClienteDTO;

public interface ICliente {

    List<ClienteDTO> getAll();
    
    Optional<ClienteDTO> getCliente(Long id);

    ClienteDTO save(ClienteDTO clienteDTO);

    void delete(Long id);
}
