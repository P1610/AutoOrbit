package com.project.carventure.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.address.AddressDao;
import com.project.carventure.address.UserAddress;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AddressDao addressDao;

	@Override
	public Admin updateAdmin(AdminDto adminDto, Integer adminId) {
		Admin foundAdmin = this.adminDao.findById(adminId).orElseThrow(() -> new AdminException("Admin not found"));
		UserAddress address = adminDto.getAddress();
		this.addressDao.save(address);
		foundAdmin.setEmail(adminDto.getEmail());
		foundAdmin.setPhone(adminDto.getPhone());
		foundAdmin.setUserAddress(address);
		foundAdmin.setUsername(adminDto.getUsername());
		return this.adminDao.save(foundAdmin);
	}

	@Override
	public Admin changePassword(AdminPasswordDto pwdDto, Integer adminId) {
		Admin admin = this.adminDao.findById(adminId).orElseThrow(() -> new AdminException("Admin not found"));
		admin.setPassword(pwdDto.getPassword());
		return this.adminDao.save(admin);
	}

	@Override
	public Admin fetchAdmin(Integer adminId) {
		return adminDao.findById(adminId).orElseThrow(() -> new AdminException("Admin not found"));
	}

}
