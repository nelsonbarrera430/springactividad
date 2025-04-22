package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.crud.OrderItemRepository;
import com.example.market.infraestructure.crud.ProductoRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.OrderItem;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.mapper.OrderItemMapper;

@Service
public class OrderItemImp implements IOrderItem {

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private OrderItemMapper mapper;

    @Override
    public List<OrderItemDTO> getItemsByOrden(Long ordenId) {
        Orden orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        return itemRepository.findByOrden(orden)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO addItem(Long ordenId, OrderItemDTO dto) {
        Orden orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        Producto producto = productoRepository.findById(dto.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        OrderItem item = mapper.toEntity(dto, orden, producto);
        return mapper.toDto(itemRepository.save(item));
    }

    @Override
    public OrderItemDTO updateItem(Long ordenId, Long itemId, OrderItemDTO dto) {
        dto.setId(itemId);
        return addItem(ordenId, dto);
    }

    @Override
    public void deleteItem(Long ordenId, Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
