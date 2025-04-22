package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ClienteDTO;
import com.example.market.domain.repository.ICliente;
import com.example.market.infraestructure.crud.ClienteRepository;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.mapper.ClienteMapper;

@Repository
public class ClienteImp implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public List<ClienteDTO> getAll() {
        return clienteRepository.findAll()
                .stream()
                .map(mapper::toClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> getCliente(Long id) {
        return clienteRepository.findById(id)
                .map(mapper::toClienteDTO);
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.toCliente(clienteDTO);
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return mapper.toClienteDTO(clienteGuardado);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}

