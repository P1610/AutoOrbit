package com.project.carventure.testdrive;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.car.Car;
import com.project.carventure.inventory.Inventory;
import com.project.carventure.inventory.InventoryDao;
import com.project.carventure.inventory.InventoryException;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

@Service
public class TestDriveServiceImplementation implements TestDriveService {

	@Autowired
	private TestDriveDao testDriveDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public Collection<TestDrive> viewTestDrives() {
		return this.testDriveDao.findAll();
	}

	@Override
	public Boolean changeStatus(StatusDto testDrive, Integer testDriveId) {
		TestDrive foundTestDrive = this.testDriveDao.findById(testDriveId).orElse(null);
		if (foundTestDrive == null) {
			throw new TestDriveException("Test drive not found with the Id");
		} else {
			foundTestDrive.setStatus(testDrive.getStatus());
			this.testDriveDao.save(foundTestDrive);
			return true;
		}

	}

	@Override
	public TestDrive addTestDrive(TestDrive testDrive, Integer inventoryId, Integer userId) {
		User user = this.userDao.findById(userId).orElseThrow(() -> new UserException("user not found with the Id"));
		Inventory inventory = this.inventoryDao.findById(inventoryId)
				.orElseThrow(() -> new InventoryException("Inventory not found with the Id "));
		Car car = inventory.getCar();
		testDrive.setCar(car);
		testDrive.setUser(user);
		TestDrive createTestDrive = this.testDriveDao.save(testDrive);
		user.getTestDrive().add(createTestDrive);
		return createTestDrive;
	}

	@Override
	public Collection<TestDrive> getAllTestDrivesByUserId(Integer userId) {
		User user = this.userDao.findById(userId).orElseThrow(() -> new UserException("user not found"));
		return this.testDriveDao.findByUserId(userId);
	}

}
