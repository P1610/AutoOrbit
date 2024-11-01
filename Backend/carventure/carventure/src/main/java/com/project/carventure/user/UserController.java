package com.project.carventure.user;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.carventure.address.UserAddress;
import com.project.carventure.transaction.Transaction;

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

	@PostMapping("/user")
	public User viewUser(@RequestBody LoginDto logindto) {
		return this.userService.viewUserByEmail(logindto);

	}

	@PatchMapping("/update/user/{userId}")
	public User updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
		return this.userService.updateUser(userDto, userId);
	}

	@GetMapping("boughtcars/{userId}")
	public Collection<Transaction> boughtCars(@PathVariable Integer userId) {
		return this.userService.boughtCars(userId);
	}

	@PatchMapping("user/password/{userId}")
	public Boolean changePassword(@RequestBody @Valid UserPasswordDto pwd, @PathVariable Integer userId) {
		return this.userService.changePassword(pwd, userId);
	}

}
