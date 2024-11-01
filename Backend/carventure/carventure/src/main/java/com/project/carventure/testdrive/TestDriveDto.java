package com.project.carventure.testdrive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carventure.car.Car;
import com.project.carventure.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

public class TestDriveDto {

	private Integer id;
	private String date;
	private String time_slot;
	private String status;

	private Car car;

	private User user;

	public TestDriveDto() {
		super();
	}

	public TestDriveDto(Integer id, String date, String time_slot, String status, Car car, User user) {
		super();
		this.id = id;
		this.date = date;
		this.time_slot = time_slot;
		this.status = status;
		this.car = car;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime_slot() {
		return time_slot;
	}

	public void setTime_slot(String time_slot) {
		this.time_slot = time_slot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
