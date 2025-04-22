package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.service.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Obtener todos los productos
    @GetMapping
    public List<ProductDTO> obtenerProductos() {
        return productService.obtenerTodo();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public Optional<ProductDTO> obtenerProductoPorId(@PathVariable("id") Long idProducto) {
        return productService.obtenerPorId(idProducto);
    }

    // Guardar un producto (POST)
    @PostMapping
    public ProductDTO guardarProducto(@RequestBody ProductDTO productDTO) {
        return productService.guardar(productDTO);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public boolean eliminarProducto(@PathVariable("id") Long idProducto) {
        return productService.eliminar(idProducto);
    }
}
