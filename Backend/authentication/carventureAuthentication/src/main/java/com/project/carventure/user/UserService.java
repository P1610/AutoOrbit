package com.project.carventure.user;

import java.util.Collection;

import com.project.carventure.address.UserAddress;
import com.project.carventure.transaction.Transaction;

public interface UserService {

	public User addNewUser(User user);

	public User login(LoginDto loginDto);

	public Boolean forgotPassword(ForgetPasswordDto email);

}
