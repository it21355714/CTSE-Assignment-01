package com.project.microservices.inventory.Controller;

import com.project.microservices.inventory.Service.InventoryService;
import com.project.microservices.inventory.dto.InventoryRequest;
import com.project.microservices.inventory.dto.InventoryResponse;
import com.project.microservices.inventory.model.Inventory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	private final InventoryService inventoryService;
	
	@GetMapping("/check-stock")
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@RequestParam String id, @RequestParam int quantity) {
        return inventoryService.isInStock(id, quantity);
    }

	@GetMapping("/all")
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllInventory();
	}
	/* 
	@PostMapping("/add")
	public Inventory addInventory(@RequestBody Inventory inventory) {
		return inventoryService.addInventory(inventory);
	}
	*/
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public InventoryResponse addInventory(@RequestBody InventoryRequest request) {
    	return inventoryService.addInventory(request);
	}	

	@PutMapping("/update/{id}")	
	public Inventory updateInventory(@Valid @PathVariable String id, @RequestBody Inventory inventory) {
		return inventoryService.updateInventory(id, inventory);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteInventory(@PathVariable String id) {
		inventoryService.deleteInventory(id);
	}

}
