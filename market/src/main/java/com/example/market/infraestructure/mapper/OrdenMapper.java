package com.example.market.infraestructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.market.domain.dto.OrdenDTO;
import com.example.market.infraestructure.crud.ClienteRepository;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.entity.Orden;

@Component
public class OrdenMapper {

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdenDTO toDto(Orden orden) {
        OrdenDTO dto = new OrdenDTO();
        dto.setId(orden.getId());
        dto.setClienteId(orden.getCliente().getId());
        dto.setFecha(orden.getFecha());
        dto.setEstado(orden.getEstado());
        dto.setTotal(orden.getTotal());
        return dto;
    }

    public Orden toEntity(OrdenDTO dto) {
        Orden orden = new Orden();
        orden.setId(dto.getId());
        orden.setFecha(dto.getFecha());
        orden.setEstado(dto.getEstado());
        orden.setTotal(dto.getTotal());

        // ✅ Aquí está lo importante: asignar el cliente
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
        orden.setCliente(cliente);

        return orden;
    }
}
