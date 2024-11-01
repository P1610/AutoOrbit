package com.project.carventure.testdrive;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.project.carventure.util.JwtUtil;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class TestDriveController {

	@Autowired
	private TestDriveService testDriveService;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/testdrives")
	public Collection<TestDriveDto> getAllTestDrives(
			@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {

		try {
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				// Extract the Bearer token
				String bearerToken = authorizationHeader.substring(7);
				System.out.println(bearerToken);
				this.jwtUtil.validateToken(bearerToken);
			}

		} catch (Exception e) {
			throw new TestDriveException("Please login");
		}
		Collection<TestDrive> testDrives = this.testDriveService.viewTestDrives();
		Collection<TestDriveDto> testDriveDtos = testDrives.stream().map(testDrive -> {
			TestDriveDto dto = new TestDriveDto();
			dto.setId(testDrive.getId());
			dto.setCar(testDrive.getCar());
			dto.setDate(testDrive.getDate());
			dto.setStatus(testDrive.getStatus());
			dto.setTime_slot(testDrive.getTime_slot());
			dto.setUser(testDrive.getUser());
			return dto;
		}).collect(Collectors.toList());

		return testDriveDtos;
	}

	@PatchMapping("/testdrive/{testDriveId}")
	public Boolean changeStatus(@RequestBody StatusDto testDrive, @PathVariable Integer testDriveId) {
		return this.testDriveService.changeStatus(testDrive, testDriveId);
	}

	@PostMapping("/testdrive/{inventoryId}/{userId}")
	public TestDrive createTestDrive(@RequestBody @Valid TestDrive testDrive, @PathVariable Integer inventoryId,
			@PathVariable Integer userId) {
		return this.testDriveService.addTestDrive(testDrive, inventoryId, userId);

	}

	@GetMapping("/testdrive/{userId}")
	public Collection<TestDrive> getAllTestDrivesByUserId(@PathVariable("userId") Integer userId) {
		return this.testDriveService.getAllTestDrivesByUserId(userId);
	}

}
