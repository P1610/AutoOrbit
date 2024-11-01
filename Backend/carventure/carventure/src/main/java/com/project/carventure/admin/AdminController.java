package com.project.carventure.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private AdminService adminService;

//	@PostMapping("/admin/autoorbit/login")
//	public Admin login(@RequestBody LoginDto loginDto) {
//		return this.adminService.login(loginDto);
//	}

	@PatchMapping("/update/admin/{adminId}")
	public Admin updateAdmin(@RequestBody AdminDto adminDto, @PathVariable Integer adminId) {
		return this.adminService.updateAdmin(adminDto, adminId);
	}

	@PatchMapping("/admin/password/{adminId}")
	public Admin changePassword(@RequestBody AdminPasswordDto pwdDto, @PathVariable Integer adminId) {
		return this.adminService.changePassword(pwdDto, adminId);
	}

	@GetMapping("/admin/{adminId}")
	public Admin fetchAdmin(@PathVariable Integer adminId) {
		return this.adminService.fetchAdmin(adminId);
	}

}
