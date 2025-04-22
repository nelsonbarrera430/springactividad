package com.example.market.infraestructure.mapper;

import org.springframework.stereotype.Component;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.OrderItem;
import com.example.market.infraestructure.entity.Producto;

@Component
public class OrderItemMapper {

    public OrderItemDTO toDto(OrderItem entity) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(entity.getId());
        dto.setProductoId(entity.getProducto().getId());
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        return dto;
    }

    public OrderItem toEntity(OrderItemDTO dto, Orden orden, Producto producto) {
        OrderItem item = new OrderItem();
        item.setId(dto.getId());
        item.setOrden(orden);
        item.setProducto(producto);
        item.setCantidad(dto.getCantidad());
        item.setPrecioUnitario(dto.getPrecioUnitario());
        return item;
    }
}
