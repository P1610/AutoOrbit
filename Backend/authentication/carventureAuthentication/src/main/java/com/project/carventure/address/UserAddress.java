package com.project.carventure.address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserAddress {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer houseNumber;
	private String streetName;
	private String city;
	private String state;
	private String pincode;

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(Integer id, Integer houseNumber, String streetName, String city, String state, String pincode) {
		super();
		this.id = id;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
