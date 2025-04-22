package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructure.crud.ProductoRepository;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.mapper.ProductMapper;

@Repository
public class ProductoImp {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductMapper mapper;

    public List<ProductDTO> getAll() {
        return productoRepository.findAll().stream()
            .map(mapper::toProductDTO)
            .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProduct(Long idProducto) {
        return productoRepository.findById(idProducto)
            .map(mapper::toProductDTO);
    }

    public ProductDTO save(ProductDTO productDTO) {
        Producto entidad = mapper.toProducto(productDTO);
        Producto guardado = productoRepository.save(entidad);
        return mapper.toProductDTO(guardado);
    }

    public boolean delete(Long idProducto) {
        return productoRepository.findById(idProducto)
            .map(p -> {
                productoRepository.delete(p);
                return true;
            })
            .orElse(false);
    }
}
