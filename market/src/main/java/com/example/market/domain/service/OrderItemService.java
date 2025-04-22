package com.example.market.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.infraestructure.crud.OrdenRepository;
import com.example.market.infraestructure.crud.OrderItemRepository;
import com.example.market.infraestructure.crud.ProductoRepository;
import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.OrderItem;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.mapper.OrderItemMapper;

@Service
public class OrderItemService {

    private final OrderItemRepository itemRepository;
    private final OrdenRepository ordenRepository;
    private final ProductoRepository productoRepository;
    private final OrderItemMapper mapper;

    public OrderItemService(OrderItemRepository itemRepository,
                            OrdenRepository ordenRepository,
                            ProductoRepository productoRepository,
                            OrderItemMapper mapper) {
        this.itemRepository = itemRepository;
        this.ordenRepository = ordenRepository;
        this.productoRepository = productoRepository;
        this.mapper = mapper;
    }

    public List<OrderItemDTO> getItemsByOrden(Long ordenId) {
        Orden orden = ordenRepository.findById(ordenId)
            .orElseThrow(() -> new RuntimeException("Orden con ID " + ordenId + " no encontrada"));

        return itemRepository.findByOrden(orden)
            .stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    public OrderItemDTO addItem(Long ordenId, OrderItemDTO dto) {
        Orden orden = ordenRepository.findById(ordenId)
            .orElseThrow(() -> new RuntimeException("Orden con ID " + ordenId + " no encontrada"));
        Producto producto = productoRepository.findById(dto.getProductoId())
            .orElseThrow(() -> new RuntimeException("Producto con ID " + dto.getProductoId() + " no encontrado"));

        OrderItem item = mapper.toEntity(dto, orden, producto);
        OrderItem savedItem = itemRepository.save(item);
        return mapper.toDto(savedItem);
    }

    public OrderItemDTO updateItem(Long ordenId, Long itemId, OrderItemDTO dto) {
        if (!itemRepository.existsById(itemId)) {
            throw new RuntimeException("Item con ID " + itemId + " no existe");
        }
        Orden orden = ordenRepository.findById(ordenId)
            .orElseThrow(() -> new RuntimeException("Orden con ID " + ordenId + " no encontrada"));
        Producto producto = productoRepository.findById(dto.getProductoId())
            .orElseThrow(() -> new RuntimeException("Producto con ID " + dto.getProductoId() + " no encontrado"));

        dto.setId(itemId);
        OrderItem itemToUpdate = mapper.toEntity(dto, orden, producto);
        OrderItem updatedItem = itemRepository.save(itemToUpdate);
        return mapper.toDto(updatedItem);
    }

    public void deleteItem(Long ordenId, Long itemId) {
        if (!itemRepository.existsById(itemId)) {
            throw new RuntimeException("Item con ID " + itemId + " no existe");
        }
        itemRepository.deleteById(itemId);
    }
}
