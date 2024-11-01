package com.project.carventure.email;

import com.project.carventure.inventory.Inventory;
import com.project.carventure.testdrive.TestDrive;
import com.project.carventure.user.User;

public class TestDriveEmail {

	private User user;
	private Inventory inventory;
	private TestDrive testDrive;

	public TestDriveEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestDriveEmail(User user, Inventory inventory, TestDrive testDrive) {
		super();
		this.user = user;
		this.inventory = inventory;
		this.testDrive = testDrive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public TestDrive getTestDrive() {
		return testDrive;
	}

	public void setTestDrive(TestDrive testDrive) {
		this.testDrive = testDrive;
	}

}
