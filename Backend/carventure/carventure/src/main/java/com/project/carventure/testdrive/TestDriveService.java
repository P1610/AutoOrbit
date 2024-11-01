package com.project.carventure.testdrive;

import java.util.Collection;

public interface TestDriveService {

	public Collection<TestDrive> viewTestDrives();

	public Boolean changeStatus(StatusDto testDrive, Integer id);

	public TestDrive addTestDrive(TestDrive testDrive, Integer inventoryId, Integer userId);

	public Collection<TestDrive> getAllTestDrivesByUserId(Integer userId);

}
