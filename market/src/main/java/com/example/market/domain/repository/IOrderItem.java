package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.OrderItemDTO;

public interface IOrderItem {

    List<OrderItemDTO> getItemsByOrden(Long ordenId);

    OrderItemDTO addItem(Long ordenId, OrderItemDTO dto);

    OrderItemDTO updateItem(Long ordenId, Long itemId, OrderItemDTO dto);

    void deleteItem(Long ordenId, Long itemId);
}
