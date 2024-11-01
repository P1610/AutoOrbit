package com.project.carventure.email;

import com.project.carventure.car.Car;
import com.project.carventure.user.User;

public class EmailRequest {

	private String adminEmail = "princechhabra1973@gmail.com";
	private User user;
	private Car car;

	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailRequest(String adminEmail, User user, Car car) {
		super();
		this.adminEmail = adminEmail;
		this.user = user;
		this.car = car;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
