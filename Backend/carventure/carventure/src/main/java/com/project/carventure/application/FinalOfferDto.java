package com.project.carventure.application;

public class FinalOfferDto {

	private Integer final_offer;
	private Integer inventory_price;
	private String status;
	private String username;
	private String email;

	public FinalOfferDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalOfferDto(Integer final_offer, Integer inventory_price, String status, String username, String email) {
		super();
		this.final_offer = final_offer;
		this.inventory_price = inventory_price;
		this.status = status;
		this.username = username;
		this.email = email;
	}

	public Integer getFinal_offer() {
		return final_offer;
	}

	public void setFinal_offer(Integer final_offer) {
		this.final_offer = final_offer;
	}

	public Integer getInventory_price() {
		return inventory_price;
	}

	public void setInventory_price(Integer inventory_price) {
		this.inventory_price = inventory_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
