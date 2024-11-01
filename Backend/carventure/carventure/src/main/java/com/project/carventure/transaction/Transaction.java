package com.project.carventure.transaction;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carventure.car.Car;
import com.project.carventure.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate transaction_date = LocalDate.now();
	private Integer amount;
	private Integer discount_percentage;
	private Integer asking_price;

	@OneToOne
	// @JsonIgnore
	private Car car;

	@ManyToOne
	@JsonIgnore
	private User user;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer id, LocalDate transaction_date, Integer amount, Integer discount_percentage,
			Integer asking_price, Car car, User user) {
		super();
		this.id = id;
		this.transaction_date = transaction_date;
		this.amount = amount;
		this.discount_percentage = discount_percentage;
		this.asking_price = asking_price;
		this.car = car;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(Integer discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public Integer getAsking_price() {
		return asking_price;
	}

	public void setAsking_price(Integer asking_price) {
		this.asking_price = asking_price;
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
