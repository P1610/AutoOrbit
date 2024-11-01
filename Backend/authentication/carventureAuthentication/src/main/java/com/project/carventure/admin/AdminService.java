package com.project.carventure.admin;

import org.springframework.beans.factory.annotation.Autowired;

public interface AdminService {

	public String login(LoginDto loginDto);

	public Admin getAdminByEmail(LoginDto loginDto, String jwtToken);

}
