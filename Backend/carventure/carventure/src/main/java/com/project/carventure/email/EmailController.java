package com.project.carventure.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send-email")
	public String sendEmail(@RequestBody EmailRequest request) {

		emailService.sendEmail(request.getUser().getEmail(), request.getAdminEmail(), request.getUser().getUsername(),
				request.getUser().getPhone(), request.getCar().getBrand(), request.getCar().getModel(),
				request.getCar().getReg_id());
		return "Emails sent successfully!";
	}

	@PostMapping("/booktestdrive")
	public void testDriveBook(@RequestBody TestDriveEmail testDrive) {
		emailService.bookTestDrive(testDrive);

	}

	@PostMapping("/initialoffer")
	public void initialOffer(@RequestBody ApplicationApproved offer) {
		emailService.initialOffer(offer);
	}
}
