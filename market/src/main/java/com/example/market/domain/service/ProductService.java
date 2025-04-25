package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructure.repositories.ProductoImp;

@Service
public class ProductService {

    @Autowired
    private ProductoImp productoImp;

    public List<ProductDTO> obtenerTodo() {
        return productoImp.getAll();
    }

    public Optional<ProductDTO> obtenerPorId(Long id) {
        return productoImp.getById(id);
    }

    public ProductDTO guardar(ProductDTO productDTO) {
        return productoImp.save(productDTO);
    }

    public ProductDTO actualizar(Long id, ProductDTO productDTO) {
        return productoImp.update(id, productDTO);
    }

    public boolean eliminar(Long id) {
        return productoImp.delete(id);
    }
}