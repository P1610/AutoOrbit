package com.project.carventure.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDao extends JpaRepository<Inventory, Integer> {

}
