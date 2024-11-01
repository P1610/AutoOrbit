package com.project.carventure.inventory;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.car.Car;
import com.project.carventure.car.CarDao;
import com.project.carventure.transaction.Transaction;
import com.project.carventure.transaction.TransactionDao;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;

@Service
public class InventoryServiceImplementation implements InventoryService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private TransactionDao transactionDao;

	@Autowired
	private CarDao carDao;

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public Collection<Inventory> viewAllInventories() {
		Collection<Inventory> inventories = this.inventoryDao.findAll();
		if (inventories.isEmpty()) {
			throw new InventoryException("inventory is null");
		} else
			return inventories;

	}

	@Override
	public Inventory viewInventory(Integer inventoryId) {
		return this.inventoryDao.findById(inventoryId).orElseThrow(() -> new InventoryException("Inventory not found"));
	}

	@Override
	public Inventory updateInventory(Integer inventoryId, Inventory updatedInventory) {
		Inventory inventory = inventoryDao.findById(inventoryId)
				.orElseThrow(() -> new InventoryException("Inventory not found with the Id"));

		// Update the inventory's fields
		inventory.setAskingPrice(updatedInventory.getAskingPrice());
		inventory.setBoughtPrice(updatedInventory.getBoughtPrice());
		inventory.setIsSold(updatedInventory.getIsSold());

		Car updatedCar = updatedInventory.getCar();
		Car car = inventory.getCar();

		car.setBrand(updatedCar.getBrand());
		car.setModel(updatedCar.getModel());
		car.setYear(updatedCar.getYear());
		car.setTransmission(updatedCar.getTransmission());
		car.setFuel_type(updatedCar.getFuel_type());
		car.setMileage(updatedCar.getMileage());
		car.setColor(updatedCar.getColor());
		car.setKm_driven(updatedCar.getKm_driven());
		car.setNo_of_owners(updatedCar.getNo_of_owners());
		car.setReg_id(updatedCar.getReg_id());
		car.setDescription(updatedCar.getDescription());
		car.setImage(updatedCar.getImage());

		this.carDao.save(updatedCar);
		return inventoryDao.save(inventory);
	}

	@Override
	public Boolean sellCar(Transaction transaction, Integer inventoryId, Integer userId) {
		Inventory foundInventory = this.inventoryDao.findById(inventoryId)
				.orElseThrow(() -> new InventoryException("Inventory not found with the Id"));
		Transaction createTransaction = new Transaction();
		User foundUser = this.userDao.findById(userId).orElse(null);
		Car car = foundInventory.getCar();
		createTransaction.setDiscount_percentage(transaction.getDiscount_percentage());
		createTransaction.setTransaction_date(LocalDate.now());
		createTransaction.setAmount(transaction.getAmount());
		createTransaction.setAsking_price(foundInventory.getAskingPrice());
		createTransaction.setCar(car);
		createTransaction.setUser(foundUser);
		Transaction saveTransaction = transactionDao.save(createTransaction);
		foundUser.getBoughtCars().add(saveTransaction);
		foundInventory.setIsSold(true);
		foundInventory.setTransaction(saveTransaction);
		this.userDao.save(foundUser);
		this.inventoryDao.save(foundInventory);
		return true;
	}
}