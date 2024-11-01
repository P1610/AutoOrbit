package com.project.carventure.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.address.UserAddress;
import com.project.carventure.util.JwtUtil;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public String login(LoginDto loginDto) {
		Admin foundAdmin = this.adminDao.findAdminByEmail(loginDto.getEmail());
		if (foundAdmin == null) {
			throw new AdminException("Incorrect email or password");
		} else {
			if (foundAdmin.getPassword().equals(loginDto.getPassword())) {

				String token = jwtUtil.generateToken(foundAdmin.getUsername());
				loginDto.setJwtToken(token);
				return token;
			} else {
				throw new AdminException("Incorrect email or password");
			}
		}
	}

	public Admin getAdminByEmail(LoginDto loginDto, String jwtToken) {
		// Retrieve admin details from the database

		Admin admin = adminDao.findAdminByEmail(loginDto.getEmail());
		admin.setJwtToken(jwtToken);

		return admin;
	}

}
