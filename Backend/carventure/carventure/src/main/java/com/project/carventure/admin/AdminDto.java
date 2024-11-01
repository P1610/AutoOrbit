package com.project.carventure.admin;

import com.project.carventure.address.UserAddress;

public class AdminDto {

	private String username;
	private String email;
	private String phone;
	private UserAddress address;

	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDto(String username, String email, String phone, UserAddress address) {
		super();
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

}
