package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.repository.IProduct;
import com.example.market.infraestructure.crud.ProductoRepository;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.mapper.ProductoMapper;

@Repository
public class ProductoImp implements IProduct {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Producto> productos = productoRepository.findAll();
        return productoMapper.toProductsDTO(productos);
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        return productoRepository.findById(id).map(productoMapper::toProductDTO);
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Producto producto = productoMapper.toProducto(productDTO);
        return productoMapper.toProductDTO(productoRepository.save(producto));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        if (productoRepository.existsById(id)) {
            Producto producto = productoMapper.toProducto(productDTO);
            producto.setId(id);
            return productoMapper.toProductDTO(productoRepository.save(producto));
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}