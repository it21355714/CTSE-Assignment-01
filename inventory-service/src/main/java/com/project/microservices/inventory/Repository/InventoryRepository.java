package com.project.microservices.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Integer>{

	boolean existsByIdAndQuantityGreaterThanEqual(int id, int quantity);

}
