package com.project.carventure.inventory;

import java.util.Collection;

import com.project.carventure.transaction.Transaction;

public interface InventoryService {

	public Collection<Inventory> viewAllInventories();

	public Inventory viewInventory(Integer inventoryId);

	public Inventory updateInventory(Integer inventoryId, Inventory updatedInventory);

	public Boolean sellCar(Transaction transaction, Integer inventoryId, Integer userId);

}
