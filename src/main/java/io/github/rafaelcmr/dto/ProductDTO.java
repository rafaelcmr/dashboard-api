package io.github.rafaelcmr.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String description;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String description, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public ProductDTO(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
