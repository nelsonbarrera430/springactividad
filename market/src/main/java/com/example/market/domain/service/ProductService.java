package com.example.market.domain.service;

import java.util.List;

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
    
}
