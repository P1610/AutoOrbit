package com.project.carventure.user;

import java.util.Collection;

import com.project.carventure.address.UserAddress;
import com.project.carventure.transaction.Transaction;

public interface UserService {

	public User viewUserByEmail(LoginDto logindto);

	public User updateUser(UserDto userDto, Integer userId);

	public Collection<Transaction> boughtCars(Integer userId);

	public Boolean changePassword(UserPasswordDto pwd, Integer userId);

}
