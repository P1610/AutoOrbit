package com.project.carventure.email;

public interface EmailService {

	public void sendPasswordResetEmail(String to, String newPassword);
}
