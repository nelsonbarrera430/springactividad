package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.service.OrderItemService;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping
    public List<OrderItemDTO> getItems(@PathVariable Long ordenId) {
        return service.getItemsByOrden(ordenId);
    }

    @PostMapping
    public OrderItemDTO addItem(@PathVariable Long ordenId, @RequestBody OrderItemDTO dto) {
        return service.addItem(ordenId, dto);
    }

    @PutMapping("/{itemId}")
    public OrderItemDTO updateItem(@PathVariable Long ordenId, @PathVariable Long itemId, @RequestBody OrderItemDTO dto) {
        return service.updateItem(ordenId, itemId, dto);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long ordenId, @PathVariable Long itemId) {
        service.deleteItem(ordenId, itemId);
    }
}
