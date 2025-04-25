package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.ProductDTO;

public interface IProduct {
    List<ProductDTO> getAll();
    Optional<ProductDTO> getById(Long id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    boolean delete(Long id);
}