package com.example.market.infraestructure.mapper;

import org.springframework.stereotype.Component;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructure.entity.Producto;

@Component
public class ProductMapper {

    // De entidad → DTO
    public ProductDTO toProductDTO(Producto producto) {
        ProductDTO dto = new ProductDTO();
        dto.setId(producto.getId());
        dto.setName(producto.getNombre());
        dto.setDescription(producto.getDescripcion());
        dto.setPrice(producto.getPrecio());
        return dto;
    }

    // De DTO → entidad
    public Producto toProducto(ProductDTO dto) {
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getName());
        producto.setDescripcion(dto.getDescription());
        producto.setPrecio(dto.getPrice());
        // Si más adelante agregas stock en el DTO, haz producto.setStock(...) aquí
        return producto;
    }
}
