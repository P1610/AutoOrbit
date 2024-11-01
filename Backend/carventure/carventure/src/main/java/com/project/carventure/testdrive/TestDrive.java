package com.project.carventure.testdrive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carventure.car.Car;
import com.project.carventure.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class TestDrive {
	@Id
	@GeneratedValue
	private Integer id;
//	@NotNull(message = "Date is required")
//	@FutureOrPresent(message = "The selected date cannot be in the past")
	private String date;
	@NotBlank(message = "Time slot is required")
	private String time_slot;
	private String status;

	@ManyToOne
	private Car car;

	@ManyToOne
	@JsonIgnore
	private User user;

	public TestDrive() {
		super();
	}

	public TestDrive(Integer id, String date, String time_slot, String status, User user, Car car) {
		super();
		this.id = id;
		this.date = date;
		this.time_slot = time_slot;
		this.status = status;
		this.user = user;
		this.car = car;
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
