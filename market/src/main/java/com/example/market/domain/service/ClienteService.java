package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.ClienteDTO;
import com.example.market.domain.repository.ICliente;

@Service
public class ClienteService {

    @Autowired
    private ICliente clienteRepository;

    public List<ClienteDTO> getAll() {
        return clienteRepository.getAll();
    }

    public Optional<ClienteDTO> getCliente(Long id) {
        return clienteRepository.getCliente(id);
    }

    public ClienteDTO save(ClienteDTO cliente) {
        return clienteRepository.save(cliente);
    }

    public boolean delete(Long id) {
        clienteRepository.delete(id);
        return true;
    }
}

