package com.project.carventure.application;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carventure.car.Car;
import com.project.carventure.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Application {

	@Id
	@GeneratedValue
	private Integer id;
	private String status = "Pending";
	private Integer asking_price;
	private Integer initial_offer;
	private Integer final_offer;
	private LocalDate date_of_application = LocalDate.now();
	private LocalDate date_of_purchase;
	private Integer inventory_price;
	private String rejection_reason;
	@OneToOne
	private Car car;

	@ManyToOne
	@JsonIgnore
	private User user;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(Integer id, String status, Integer asking_price, Integer initial_offer, Integer final_offer,
			LocalDate date_of_application, LocalDate date_of_purchase, Integer inventory_price, String rejection_reason,
			User user, Car car) {
		super();
		this.id = id;
		this.status = status;
		this.asking_price = asking_price;
		this.initial_offer = initial_offer;
		this.final_offer = final_offer;
		this.date_of_application = date_of_application;
		this.date_of_purchase = date_of_purchase;
		this.inventory_price = inventory_price;
		this.rejection_reason = rejection_reason;
		this.user = user;
		this.car = car;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAsking_price() {
		return asking_price;
	}

	public void setAsking_price(Integer asking_price) {
		this.asking_price = asking_price;
	}

	public Integer getInitial_offer() {
		return initial_offer;
	}

	public void setInitial_offer(Integer initial_offer) {
		this.initial_offer = initial_offer;
	}

	public Integer getFinal_offer() {
		return final_offer;
	}

	public void setFinal_offer(Integer final_offer) {
		this.final_offer = final_offer;
	}

	public LocalDate getDate_of_application() {
		return date_of_application;
	}

	public void setDate_of_application(LocalDate date_of_application) {
		this.date_of_application = date_of_application;
	}

	public LocalDate getDate_of_purchase() {
		return date_of_purchase;
	}

	public void setDate_of_purchase(LocalDate date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}

	public Integer getInventory_price() {
		return inventory_price;
	}

	public void setInventory_price(Integer inventory_price) {
		this.inventory_price = inventory_price;
	}

	public String getRejection_reason() {
		return rejection_reason;
	}

	public void setRejection_reason(String rejection_reason) {
		this.rejection_reason = rejection_reason;
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
