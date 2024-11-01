package com.project.carventure.user;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.email.EmailServiceImplementation;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EmailServiceImplementation emailService;

	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "@$!%*?&";
	private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
	private static final int PASSWORD_LENGTH = 8;
	private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public User addNewUser(User user) {
		User foundUser = this.userDao.findUserByEmail(user.getEmail());
		if (foundUser != null) {
			throw new UserException("Email already exists");
		}
		return this.userDao.save(user);
	}

	@Override
	public User login(LoginDto loginDto) {
		User foundUser = this.userDao.findUserByEmail(loginDto.getEmail());
		if (foundUser == null) {
			throw new UserException("Incorrect email or password");
		} else {
			if (!foundUser.isVerified()) {
				throw new UserException("Please verify your email.");
			}
			if (foundUser.getPassword().equals(loginDto.getPassword())) {
				return foundUser;
			} else {
				throw new UserException("Incorrect email or password");
			}
		}
	}

	private String generateRandomPassword() {
		StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

		// Ensure the password contains at least one character from each required set
		password.append(UPPERCASE.charAt(RANDOM.nextInt(UPPERCASE.length())));
		password.append(LOWERCASE.charAt(RANDOM.nextInt(LOWERCASE.length())));
		password.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
		password.append(SPECIAL_CHARACTERS.charAt(RANDOM.nextInt(SPECIAL_CHARACTERS.length())));

		// Fill the remaining characters randomly
		for (int i = 4; i < PASSWORD_LENGTH; i++) {
			password.append(ALL_CHARACTERS.charAt(RANDOM.nextInt(ALL_CHARACTERS.length())));
		}

		// Shuffle the characters to ensure randomness
		return shuffleString(password.toString());
	}

	private String shuffleString(String input) {
		List<Character> characters = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.shuffle(characters);
		StringBuilder result = new StringBuilder(characters.size());
		for (char c : characters) {
			result.append(c);
		}
		return result.toString();
	}

	@Override
	public Boolean forgotPassword(ForgetPasswordDto email) {
		String foundEmail = email.getEmail();
		User user = this.userDao.findUserByEmail(foundEmail);
		if (user != null) {
			String randomPassword = generateRandomPassword();
			user.setPassword(randomPassword);
			userDao.save(user);
			emailService.sendPasswordResetEmail(foundEmail, randomPassword);
			return true;
		}
		return false;
	}

}
