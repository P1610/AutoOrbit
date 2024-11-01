package com.project.carventure.location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Location {

	@Id
	@GeneratedValue
	private Integer id;
	private String landmark;
	private String place;
	private String city;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String landmark, String place, String city) {
		super();
		this.landmark = landmark;
		this.place = place;
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
