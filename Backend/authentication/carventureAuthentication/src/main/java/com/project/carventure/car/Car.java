package com.project.carventure.car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private Integer id;

	@NotNull(message = "Brand is required")
	@Size(min = 3, message = "Brand must be at least 3 characters long")
	private String brand;
	@NotNull(message = "Model is required")
	@Size(min = 2, message = "Model must be at least 2 characters long")
	private String model;
	@NotNull(message = "Year is required")
	@Min(value = 1950, message = "Year should not less than 1950")
	private Integer year;
	@NotNull(message = "Transmission is required")
	private String transmission;
	@NotEmpty(message = "Fuel Type is required")
	private String fuel_type;
	@NotNull(message = "Mileage is required")
	@Min(value = 1, message = "Mileage must be a positive number")
	@Max(value = 36, message = "Mileage could not be greater than 36")
	private Integer mileage;
	@NotNull(message = "Color is required")
	private String color;
	@NotNull(message = "KM Driven is required")
	@Min(value = 100, message = "KM Driven must be at least 100")
	@Max(value = 300000, message = "KM Driven must not be greater than 300000")
	private Integer km_driven;
	@NotNull(message = "Number of Owners is required")
	@Min(value = 1, message = "Number of Owners must be less than 2 and cannot be negative ")
	@Max(value = 1, message = "Number of Owners must be less than 2 and cannot be negative ")
	private Integer no_of_owners;
	@NotNull(message = "Registration ID is required")
	private String reg_id;
	@NotNull(message = "Description is required")
	@Size(min = 20, message = "Description must be at least 20 characters long")
	private String description;

	@ElementCollection
	@NotNull(message = "Image URLs are required")
	@Size(min = 1, message = "At least one image URL is required")
	private List<String> image = new ArrayList<>();

	public Car() {
		super();
	}

	public Car(Integer id, String brand, String model, Integer year, String transmission, String fuel_type,
			Integer mileage, String color, Integer km_driven, Integer no_of_owners, String reg_id, String description,
			List<String> image) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.transmission = transmission;
		this.fuel_type = fuel_type;
		this.mileage = mileage;
		this.color = color;
		this.km_driven = km_driven;
		this.no_of_owners = no_of_owners;
		this.reg_id = reg_id;
		this.description = description;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public Car(
			@NotNull(message = "Brand is required") @Size(min = 3, message = "Brand must be at least 3 characters long") String brand,
			@NotNull(message = "Model is required") @Size(min = 2, message = "Model must be at least 2 characters long") String model,
			@NotNull(message = "Year is required") @Min(value = 1950, message = "Year should not less than 1950") Integer year,
			@NotNull(message = "Transmission is required") String transmission,
			@NotEmpty(message = "Fuel Type is required") String fuel_type,
			@NotNull(message = "Mileage is required") @Min(value = 1, message = "Mileage must be a positive number") @Max(value = 36, message = "Mileage could not be greater than 36") Integer mileage,
			@NotNull(message = "Color is required") String color,
			@NotNull(message = "KM Driven is required") @Min(value = 100, message = "KM Driven must be at least 100") @Max(value = 300000, message = "KM Driven must not be greater than 300000") Integer km_driven,
			@NotNull(message = "Number of Owners is required") @Min(value = 1, message = "Number of Owners must be less than 2 and cannot be negative ") @Max(value = 1, message = "Number of Owners must be less than 2 and cannot be negative ") Integer no_of_owners,
			@NotNull(message = "Registration ID is required") String reg_id,
			@NotNull(message = "Description is required") @Size(min = 20, message = "Description must be at least 20 characters long") String description) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.transmission = transmission;
		this.fuel_type = fuel_type;
		this.mileage = mileage;
		this.color = color;
		this.km_driven = km_driven;
		this.no_of_owners = no_of_owners;
		this.reg_id = reg_id;
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getKm_driven() {
		return km_driven;
	}

	public void setKm_driven(Integer km_driven) {
		this.km_driven = km_driven;
	}

	public Integer getNo_of_owners() {
		return no_of_owners;
	}

	public void setNo_of_owners(Integer no_of_owners) {
		this.no_of_owners = no_of_owners;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

}
