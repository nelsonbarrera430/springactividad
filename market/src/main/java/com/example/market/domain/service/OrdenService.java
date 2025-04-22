package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrdenDTO;
import com.example.market.domain.repository.IOrden;
import com.example.market.infraestructure.crud.ClienteRepository;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.mapper.OrdenMapper;

@Service
public class OrdenService {

    @Autowired
    private IOrden ordenRepo;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    public List<OrdenDTO> getAll() {
        return ordenRepo.getAll();
    }

    public OrdenDTO getById(Long id) {
        Optional<OrdenDTO> dto = ordenRepo.getById(id);
        return dto.orElse(null);
    }

    public OrdenDTO save(OrdenDTO dto) {
        // Convertir a entidad
        Orden orden = ordenMapper.toEntity(dto);

        // Asignar cliente
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getClienteId()));
        orden.setCliente(cliente);

        // Guardar usando la implementación real del repositorio
        Orden saved = ordenRepo.saveEntity(orden); // necesitas agregar este método si aún no está
        return ordenMapper.toDto(saved);
    }

    public OrdenDTO update(Long id, OrdenDTO dto) {
        dto.setId(id);
        return save(dto); // puedes reutilizar save con el mismo flujo
    }

    public void delete(Long id) {
        ordenRepo.delete(id);
    }
}
