package com.project.carventure.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDto {

	@NotBlank(message = "Username is required.")
	private String username;
	@NotBlank(message = "Email is required.")
	@Email(message = "please provide valid email, e.g:name@gmail.com")
	private String email;
	@NotBlank(message = "Mobile number is required.")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits.")
	private String phone;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(@NotBlank(message = "Username is required.") String username,
			@NotBlank(message = "Email is required.") @Email(message = "please provide valid email, e.g:name@gmail.com") String email,
			@NotBlank(message = "Mobile number is required.") @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits.") String phone) {
		super();
		this.username = username;
		this.email = email;
		this.phone = phone;
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

}
