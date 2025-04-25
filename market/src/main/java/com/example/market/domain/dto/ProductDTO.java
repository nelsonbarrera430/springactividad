package com.example.market.domain.dto;



public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long stock;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
    public Long getStock() {
        return stock;
    }
    
    public void setStock(Long stock) {
        this.stock = stock;
    }
    
}
