package com.project.carventure.email;

public class ApplicationApproved {

	private String brand;
	private String model;
	private String amount;
	private String email;

	public ApplicationApproved() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicationApproved(String brand, String model, String amount, String email) {
		super();
		this.brand = brand;
		this.model = model;
		this.amount = amount;
		this.email = email;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
