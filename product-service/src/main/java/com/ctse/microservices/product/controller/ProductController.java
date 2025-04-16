package com.ctse.microservices.product.controller;

import com.ctse.microservices.product.dto.ProductRequest;
import com.ctse.microservices.product.dto.ProductResponse;
import com.ctse.microservices.product.model.Product;
import com.ctse.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();

    }

    @GetMapping("/ping")
    @ResponseStatus(HttpStatus.OK)
    public String testConnection() {
        try {
            long count = productService.getProductCount();
            return "✅ Connected to MongoDB. Product count: " + count;
        } catch (Exception e) {
            return "❌ Failed to connect to MongoDB: " + e.getMessage();
        }
    }
}
