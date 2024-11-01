package com.project.carventure.admin;

import org.springframework.beans.factory.annotation.Autowired;

public interface AdminService {

//   public Admin login(LoginDto loginDto);

	public Admin updateAdmin(AdminDto adminDto, Integer adminId);

	public Admin changePassword(AdminPasswordDto pwdDto, Integer adminId);

	public Admin fetchAdmin(Integer adminId);
}
