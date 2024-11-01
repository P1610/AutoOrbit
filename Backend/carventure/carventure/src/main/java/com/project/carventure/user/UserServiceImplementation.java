package com.project.carventure.user;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.address.AddressDao;
import com.project.carventure.address.UserAddress;
import com.project.carventure.email.EmailServiceImplementation;
import com.project.carventure.transaction.Transaction;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	AddressDao addressDao;

	@Override
	public User viewUserByEmail(LoginDto loginDto) {
		return this.userDao.findUserByEmail(loginDto.getEmail());
	}

	@Override
	public User updateUser(UserDto userDto, Integer userId) {
		User foundUser = this.userDao.findById(userId).orElse(null);
		if (foundUser == null) {
			throw new UserException("User not found with Id");
		} else {

			foundUser.setEmail(userDto.getEmail());
			foundUser.setPhone(userDto.getPhone());
			foundUser.setUsername(userDto.getUsername());

			return this.userDao.save(foundUser);
		}

	}

	@Override
	public Collection<Transaction> boughtCars(Integer userId) {
		User user = this.userDao.findById(userId).orElse(null);
		if (user == null) {
			throw new UserException("user not found with respective Id");
		}
		return user.getBoughtCars();

	}

	@Override
	public Boolean changePassword(UserPasswordDto pwd, Integer userId) {
		User user = this.userDao.findById(userId).orElse(null);
		if (user == null) {
			throw new UserException("user not found with respective Id");
		}
		user.setPassword(pwd.getPassword());
		this.userDao.save(user);
		return true;
	}

}
