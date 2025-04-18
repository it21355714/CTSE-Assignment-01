package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
