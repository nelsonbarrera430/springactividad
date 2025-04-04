package com.example.market.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.service.ProductService;


@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @GetMapping
    public List<ProductDTO> obtenerProductos(){
        return productService.obtenerTodo();
    }
    

    
}
