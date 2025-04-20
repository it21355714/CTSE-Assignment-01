package com.project.microservices.inventory.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.project.microservices.inventory.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory,String>{

	boolean existsByIdAndQuantityGreaterThanEqual(String id, int quantity);

}
