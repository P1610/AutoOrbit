package com.project.carventure.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendPasswordResetEmail(String to, String newPassword) {
		System.out.println("insied");
		System.out.println(to + newPassword);
		MimeMessage message = mailSender.createMimeMessage();

		try {
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
			String content = "Your new password is: " + newPassword;
			message.setSubject("Password Reset");
			message.setContent(content, "text/html");
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("unable to send" + e.getMessage());
		}

	}

}
