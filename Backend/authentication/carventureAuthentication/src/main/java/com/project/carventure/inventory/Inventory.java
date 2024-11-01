package com.project.carventure.inventory;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carventure.car.Car;
import com.project.carventure.transaction.Transaction;
import com.project.carventure.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer askingPrice;
	private Integer boughtPrice;
	private Boolean isSold = false;
	private LocalDate date_of_purchase = LocalDate.now();
	@OneToOne
	private Car car;

	private String sellerName;
	private String sellerEmail;

	@OneToOne
	private Transaction transaction;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(Integer id, Integer askingPrice, Integer boughtPrice, Boolean isSold) {
		super();
		this.id = id;
		this.askingPrice = askingPrice;
		this.boughtPrice = boughtPrice;
		this.isSold = isSold;
	}

	public Inventory(Integer id, Integer askingPrice, Integer boughtPrice, Boolean isSold, LocalDate date_of_purchase,
			Car car, String sellerName, String sellerEmail, Transaction transaction) {
		super();
		this.id = id;
		this.askingPrice = askingPrice;
		this.boughtPrice = boughtPrice;
		this.isSold = isSold;
		this.date_of_purchase = date_of_purchase;
		this.car = car;
		this.sellerName = sellerName;
		this.sellerEmail = sellerEmail;
		this.transaction = transaction;
	}

	public Inventory(Car car2) {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAskingPrice() {
		return askingPrice;
	}

	public void setAskingPrice(Integer askingPrice) {
		this.askingPrice = askingPrice;
	}

	public Integer getBoughtPrice() {
		return boughtPrice;
	}

	public void setBoughtPrice(Integer boughtPrice) {
		this.boughtPrice = boughtPrice;
	}

	public Boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}

	public LocalDate getDate_of_purchase() {
		return date_of_purchase;
	}

	public void setDate_of_purchase(LocalDate date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
