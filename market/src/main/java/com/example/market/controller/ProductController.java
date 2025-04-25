package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    @GetMapping
    public List<ProductDTO> obtenerProductos() {
        return productService.obtenerTodo();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> obtenerProductoPorId(@PathVariable Long id) {
        Optional<ProductDTO> producto = productService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<ProductDTO> crearProducto(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.guardar(productDTO));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.actualizar(id, productDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (productService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}