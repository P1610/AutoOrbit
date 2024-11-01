package com.project.carventure.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carventure.address.UserAddress;
import com.project.carventure.inventory.Inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Admin {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String email;
	private String phone;
	private String password;

	private String jwtToken;

	@OneToOne
	private UserAddress userAddress;

	private String image;
	private String role;

	@OneToMany
	@JsonIgnore
	private Collection<Inventory> inventory = new ArrayList<>();

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id, String username, String email, String phone, String password, String jwtToken,
			UserAddress userAddress, String image, String role, Collection<Inventory> inventory) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.jwtToken = jwtToken;
		this.userAddress = userAddress;
		this.image = image;
		this.role = role;
		this.inventory = inventory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Collection<Inventory> inventory) {
		this.inventory = inventory;
	}

}
