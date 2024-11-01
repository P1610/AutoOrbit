package com.project.carventure.email;

public interface EmailService {

	public void sendEmail(String userEmail, String adminEmail, String userName, String userPhone, String carBrand,
			String carModel, String regId);

	public void bookTestDrive(TestDriveEmail testDrive);

	public void initialOffer(ApplicationApproved offer);
}
