package com.example.market.infraestructure.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.market.infraestructure.entity.Orden;
import com.example.market.infraestructure.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findByOrden(Orden orden);
}
