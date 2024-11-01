package com.project.carventure.user;

public class ForgetPasswordDto {

	private String email;

	public ForgetPasswordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForgetPasswordDto(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
