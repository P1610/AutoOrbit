package com.project.carventure.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.carventure.address.UserAddress;
import com.project.carventure.application.Application;
import com.project.carventure.testdrive.TestDrive;
import com.project.carventure.transaction.Transaction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Username is required.")
	private String username;
	@NotBlank(message = "Email is required.")
	@Email(message = "please provide valid email, e.g:name@gmail.com")
	private String email;
	@NotBlank(message = "Mobile Number is required.")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits.")
	private String phone;
	@NotBlank(message = "Password is required.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$", message = "Password must be at least 6 characters long and include an uppercase letter, a lowercase letter, a number, and a special character.")
	private String password;

	private String verificationCode;

	private boolean verified;

//	  @JoinColumn(name = "address_id", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL)
	private UserAddress userAddress;

	@OneToMany
	private Collection<Application> applications = new ArrayList<>();

	@OneToMany
	private Collection<Transaction> boughtCars = new ArrayList<>();

	@OneToMany
	private Collection<TestDrive> testDrive = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, @NotBlank(message = "Username is required.") String username,
			@NotBlank(message = "Email is required.") @Email(message = "please provide valid email, e.g:name@gmail.com") String email,
			@NotBlank(message = "Mobile number is required.") @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits.") String phone,
			@NotBlank(message = "Password is required.") String password, String verificationCode, boolean verified,
			UserAddress userAddress, Collection<Application> applications, Collection<Transaction> boughtCars,
			Collection<TestDrive> testDrive) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.verificationCode = verificationCode;
		this.verified = verified;
		this.userAddress = userAddress;
		this.applications = applications;
		this.boughtCars = boughtCars;
		this.testDrive = testDrive;
	}

	public User(String string) {

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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public Collection<Application> getApplications() {
		return applications;
	}

	public void setApplications(Collection<Application> applications) {
		this.applications = applications;
	}

	public Collection<Transaction> getBoughtCars() {
		return boughtCars;
	}

	public void setBoughtCars(Collection<Transaction> boughtCars) {
		this.boughtCars = boughtCars;
	}

	public Collection<TestDrive> getTestDrive() {
		return testDrive;
	}

	public void setTestDrive(Collection<TestDrive> testDrive) {
		this.testDrive = testDrive;
	}

}
