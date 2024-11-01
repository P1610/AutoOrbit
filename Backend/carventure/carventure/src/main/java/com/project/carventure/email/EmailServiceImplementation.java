package com.project.carventure.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String userEmail, String adminEmail, String userName, String userPhone, String carBrand,
			String carModel, String regId) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setSubject("Thank you for showing interest!");
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(userEmail));

			String content = "Thank you for showing interest in purchasing a car.\n" + carBrand + " " + carModel
					+ "has been booked by you.\n Please contact us for more details.\n" + "Contact:" + adminEmail
					+ ", 8847219698\nAddress: KS Residency, Eelectronic City Phase-1, Bangalore\nLandMark: HappiestMinds Technologies";
			message.setContent(content, "text/html");
			mailSender.send(message);

			message.setSubject("New Car Purchase Request");
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(adminEmail));

			String admincontent = "User Information:\nName: " + userName + "\nEmail: " + userEmail + "\nPhone: "
					+ userPhone + "\nCar Details:\nBrand: " + carBrand + "\nModel: " + carModel + "\nRegistration: "
					+ regId;
			message.setContent(admincontent, "text/html");
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Error sending verification email: " + e.getMessage());
		}
	}

	@Override
	public void bookTestDrive(TestDriveEmail testDrive) {
		MimeMessage message = mailSender.createMimeMessage();
		String userEmail = testDrive.getUser().getEmail();
		String carBrand = testDrive.getInventory().getCar().getBrand();
		String carModel = testDrive.getInventory().getCar().getModel();
		String date = testDrive.getTestDrive().getDate();
		String time = testDrive.getTestDrive().getTime_slot();
		String adminEmail = "princechhabra1973@gmail.com";
		try {
			message.setSubject("Successfull booking of a test drive!");
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(userEmail));

			String content = "Test drive has been booked for the car: " + carBrand + " " + carModel + "\nDate: " + date
					+ "\nTime Slot: " + time + " \nPlease contact us for any query.\n" + "Contact:" + adminEmail
					+ ", 8847219698\nAddress: KS Residency, Eelectronic City Phase-1, Bangalore\nLandMark: HappiestMinds Technologies";
			message.setContent(content, "text/html");
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Error sending verification email: " + e.getMessage());
		}
	}

	@Override
	public void initialOffer(ApplicationApproved offer) {
		MimeMessage message = mailSender.createMimeMessage();
		String brand = offer.getBrand();
		String model = offer.getModel();
		String amount = offer.getAmount();
		String userEmail = offer.getEmail();
		try {
			message.setSubject("Application approval");
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(userEmail));

			String content = "You application of  " + brand + " " + model
					+ " has been approved with an offer amount of INR " + amount
					+ " Please contact us for any query or negotiation.\n"
					+ "Contact: princechhabra1973@gmail.com , 8847219698\nAddress: KS Residency, Eelectronic City Phase-1, Bangalore\nLandMark: HappiestMinds Technologies";
			message.setContent(content, "text/html");
			mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("Error sending email: " + e.getMessage());
		}

	}

//		public void sendPasswordResetEmail(String to, String newPassword) {
//	        SimpleMailMessage message = new SimpleMailMessage();
//	        message.setTo(to);
//	        message.setSubject("Password Reset");
//	        message.setText("Your new password is: " + newPassword);
//	        mailSender.send(message);
//	    }
//    
}
