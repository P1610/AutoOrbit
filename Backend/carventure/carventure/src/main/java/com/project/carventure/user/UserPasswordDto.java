package com.project.carventure.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserPasswordDto {
	@NotBlank(message = "Password is required.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$", message = "Password must be at least 6 characters long and include an uppercase letter, a lowercase letter, a number, and a special character.")
	private String password;

	public UserPasswordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPasswordDto(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
