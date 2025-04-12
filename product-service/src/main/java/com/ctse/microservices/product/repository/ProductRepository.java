package com.ctse.microservices.product.repository;

import com.ctse.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Custom query methods can be defined here if needed
    // For example, findByCategoryId(String categoryId);
}
