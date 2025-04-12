package com.ctse.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, String categoryId, BigDecimal price) {
    // This record will automatically generate the constructor, getters, and toString method
    // No need for additional annotations or boilerplate code
}
