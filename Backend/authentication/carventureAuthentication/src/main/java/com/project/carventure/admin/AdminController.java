package com.project.carventure.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.carventure.util.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/admin/autoorbit/login")
	public ResponseEntity<Admin> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {

		String jwtToken = this.adminService.login(loginDto);

		Cookie cookie = new Cookie("jwt", jwtToken);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath("/");
		cookie.setAttribute("SameSite", "None");
		response.addCookie(cookie);

		Admin admin = adminService.getAdminByEmail(loginDto, jwtToken);
		return ResponseEntity.ok(admin);
	}

	@PatchMapping("/autoorbit/logout")
	public ResponseEntity<?> logoutUser(HttpServletResponse response) {

		Cookie jwtCookie = new Cookie("jwt", null);

		jwtCookie.setHttpOnly(true);
		jwtCookie.setSecure(false);
		jwtCookie.setPath("/");

		jwtCookie.setAttribute("SameSite", "None");

		response.addCookie(jwtCookie);
		return ResponseEntity.ok("true");
	}

}
