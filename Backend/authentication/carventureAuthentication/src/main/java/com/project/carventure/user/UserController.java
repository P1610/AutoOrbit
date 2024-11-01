package com.project.carventure.user;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Autowired
	private JavaMailSender javaMailSender;

	public static String generateVerificationCode() {
		final int CODE_LENGTH = 6; // Adjust length as needed
		StringBuilder code = new StringBuilder();
		Random random = new SecureRandom();
		for (int i = 0; i < CODE_LENGTH; i++) {
			int randomInt = random.nextInt(10); // Generate a random digit
			code.append(randomInt);
		}
		return code.toString();
	}

	public void sendVerificationEmail(String email, String verificationCode) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			message.setSubject("Verify Your Email Address for Your App");
			message.setFrom("chhabraprince1973@gmail.com"); // Adjust sender address
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));

			String content = "Click the following link to verify your email address:\n"
					+ "http://localhost:8092/verify?code=" + verificationCode;
			message.setContent(content, "text/html"); // Set content as HTML

			javaMailSender.send(message);
			System.out.println("Verification email sent successfully!");
		} catch (MessagingException e) {
			System.out.println("Error sending verification email: " + e.getMessage());
		}
	}

	@PostMapping("/register")
	public User registerNewUser(@Valid @RequestBody User user) {
		String verificationCode = generateVerificationCode();
		user.setVerificationCode(verificationCode);
		sendVerificationEmail(user.getEmail(), verificationCode);
		return this.userService.addNewUser(user);
	}

	@GetMapping("/verify")
	public ResponseEntity<?> verifyEmail(@RequestParam String code) {
		User user = userDao.findByVerificationCode(code);
		if (user != null) {
			user.setVerified(true);
			userDao.save(user);
			return ResponseEntity.ok("Email verified successfully.");
		} else {
			return ResponseEntity.badRequest().body("Invalid verification code.");
		}
	}

	@PostMapping("/user/autoorbit/login")
	public User login(@RequestBody @Valid LoginDto loginDto) {
		return this.userService.login(loginDto);
	}

	@PostMapping("user/forgotpassword")
	public Boolean forgotPassword(@RequestBody ForgetPasswordDto email) {
		return this.userService.forgotPassword(email);
	}

}
