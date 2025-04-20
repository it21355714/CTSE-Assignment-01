package com.project.microservices.inventory.Service;

import com.project.microservices.inventory.model.Inventory;
import com.project.microservices.inventory.Repository.InventoryRepository;
import com.project.microservices.inventory.dto.InventoryRequest;
import com.project.microservices.inventory.dto.InventoryResponse;
import com.project.microservices.inventory.Exception.InventoryNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.github.resilience4j.retry.annotation.Retry;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j

public class InventoryService {
	private final InventoryRepository inventoryRepository;
	
	//Check if an inventory is in stock for a given name and quantity
	public boolean isInStock(String id, int quantity) {
		log.info("Checking if inventory with ID {} is in stock with quantity {}", id, quantity);
		return inventoryRepository.existsByIdAndQuantityGreaterThanEqual(id, quantity);
	}

	//Get all inventories
	public List<Inventory> getAllInventory() {
		log.info("Fetching all inventories");
        return inventoryRepository.findAll();
    }

	@Retry(name = "inventoryService", fallbackMethod = "fallbackGetInventoryById")
	public Inventory getInventoryById(String id) {
    log.info("Fetching inventory with ID {}", id);
    return inventoryRepository.findById(id)
            .orElseThrow(() -> new InventoryNotFoundException("Inventory with ID " + id + " not found"));
}

public Inventory fallbackGetInventoryById(String id, Exception ex) {
    log.error("Fallback triggered for ID {}: {}", id, ex.getMessage());
    Inventory fallback = new Inventory();
    fallback.setId(id);
    fallback.setName("Unavailable");
    fallback.setQuantity(0);
    return fallback;
}
	//Add a new inventory
	public InventoryResponse addInventory(InventoryRequest request) {
    Inventory inventory = new Inventory();
    inventory.setName(request.getName());
    inventory.setQuantity(request.getQuantity());
    inventory.setPrice(request.getPrice());
	
    Inventory saved = inventoryRepository.save(inventory);

    return new InventoryResponse(
        saved.getId(),
        saved.getName(),
		saved.getQuantity(),
        saved.getPrice(),
        saved.getCreated_at()
    );
}


	//Delete an inventory by id
	public void deleteInventory(String id) {
		log.info("Deleting inventory with ID {}", id);
		inventoryRepository.deleteById(id);
	}

	//Update an inventory by id
	public Inventory updateInventory(@PathVariable String id, @Valid @RequestBody Inventory updatedInventory) {
		log.info("Updating inventory with ID {}: {}", id, updatedInventory);
		Inventory existingInventory = inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFoundException("Inventory with ID " + id + " not found"));
		if (existingInventory != null) {
			existingInventory.setName(updatedInventory.getName());
			existingInventory.setQuantity(updatedInventory.getQuantity());
			return inventoryRepository.save(existingInventory);
		}
		return null;
	}

}
