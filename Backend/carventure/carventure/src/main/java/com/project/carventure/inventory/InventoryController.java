package com.project.carventure.inventory;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.carventure.transaction.Transaction;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/inventory")
	public Collection<Inventory> viewAllInventories() {
		return this.inventoryService.viewAllInventories();
	}

	@GetMapping("/inventory/{inventoryId}")
	public Inventory ViewInventory(@PathVariable Integer inventoryId) {
		return this.inventoryService.viewInventory(inventoryId);
	}

	@PutMapping("/inventory/{inventoryId}")
	public Inventory updateInventory(@PathVariable Integer inventoryId, @RequestBody Inventory updatedInventory) {
		return this.inventoryService.updateInventory(inventoryId, updatedInventory);
	}

	@PatchMapping("/inventory/{inventoryId}/{userId}")
	public Boolean sellCar(@RequestBody Transaction transaction, @PathVariable Integer inventoryId,
			@PathVariable Integer userId) {
		return this.inventoryService.sellCar(transaction, inventoryId, userId);
	}

}
