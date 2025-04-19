package com.project.microservices.inventory.Service;

import com.project.microservices.inventory.model.Inventory;
import com.project.microservices.inventory.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class InventoryService {
	private final InventoryRepository inventoryRepository;
	
	//Check if an inventory is in stock for a given name and quantity
	public boolean isInStock(int id, int quantity) {
		return inventoryRepository.existsByIdAndQuantityGreaterThanEqual(id, quantity);
	}

	//Get all inventories
	public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

	//Get inventory by id
	public Inventory getInventoryById(int id) {
		return inventoryRepository.findById(id).orElse(null);
	}

	//Add a new inventory
	public Inventory addInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	} 

	//Delete an inventory by id
	public void deleteInventory(int id) {
		inventoryRepository.deleteById(id);
	}

	//Update an inventory by id
	public Inventory updateInventory(int id, Inventory inventory) {
		Inventory existingInventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
		if (existingInventory != null) {
			existingInventory.setName(inventory.getName());
			existingInventory.setQuantity(inventory.getQuantity());
			return inventoryRepository.save(existingInventory);
		}
		return null;
	}

}
