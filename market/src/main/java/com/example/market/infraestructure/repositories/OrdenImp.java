package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.OrdenDTO;
import com.example.market.domain.repository.IOrden;
import com.example.market.infraestructure.crud.ClienteRepository;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.mapper.OrdenMapper;

@Repository
public class OrdenImp implements IOrden {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    @Override
    public List<OrdenDTO> getAll() {
        return ordenRepository.findAll()
                .stream()
                .map(ordenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrdenDTO> getById(Long id) {
        return ordenRepository.findById(id)
                .map(ordenMapper::toDto);
    }

    @Override
    public OrdenDTO save(OrdenDTO dto) {
        // 1) Verificar cliente existente
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        // 2) Convertir DTO a entidad y asignar cliente
        Orden orden = ordenMapper.toEntity(dto);
        orden.setCliente(cliente);
        // 3) Guardar y mapear de nuevo a DTO
        Orden saved = ordenRepository.save(orden);
        return ordenMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public Orden saveEntity(Orden orden) {
        return ordenRepository.save(orden);
    }
}

