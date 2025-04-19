package com.project.microservices.inventory.Controller;

import com.project.microservices.inventory.Service.InventoryService;
import com.project.microservices.inventory.model.Inventory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	private final InventoryService inventoryService;
	
	@GetMapping("/check-stock")
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@RequestParam int id, @RequestParam int quantity) {
        return inventoryService.isInStock(id, quantity);
    }

	@GetMapping("/all")
	public List<Inventory> getAllInventory() {
		return inventoryService.getAllInventory();
	}

	@PostMapping("/add")
	public Inventory addInventory(@RequestBody Inventory inventory) {
		return inventoryService.addInventory(inventory);
	}

	@PutMapping("/update/{id}")	
	public Inventory updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
		return inventoryService.updateInventory(id, inventory);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteInventory(@PathVariable int id) {
		inventoryService.deleteInventory(id);
	}

}
