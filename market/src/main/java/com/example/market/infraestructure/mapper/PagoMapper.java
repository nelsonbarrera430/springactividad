package com.example.market.infraestructure.mapper;

import org.springframework.stereotype.Component;

import com.example.market.domain.dto.PagoDTO;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.Pago;

@Component
public class PagoMapper {

    public PagoDTO toDto(Pago pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setMonto(pago.getMonto());
        dto.setFechaPago(pago.getFechaPago());
        dto.setMetodoPago(pago.getMetodoPago());
        dto.setOrdenId(pago.getOrden().getId());
        return dto;
    }

    public Pago toEntity(PagoDTO dto, Orden orden) {
        Pago pago = new Pago();
        pago.setId(dto.getId());
        pago.setMonto(dto.getMonto());
        pago.setFechaPago(dto.getFechaPago());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setOrden(orden);
        return pago;
    }
}
