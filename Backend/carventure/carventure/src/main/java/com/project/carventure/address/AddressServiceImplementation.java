package com.project.carventure.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

@Service
public class AddressServiceImplementation implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Boolean addAddress(UserAddress address, Integer userId) {
		User foundUser = this.userDao.findById(userId).orElseThrow(() -> new UserException("user not found"));

		UserAddress createAddress = this.addressDao.save(address);
		foundUser.setUserAddress(createAddress);
		this.userDao.save(foundUser);
		return true;

	}

}
