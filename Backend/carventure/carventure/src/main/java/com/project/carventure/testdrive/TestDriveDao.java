package com.project.carventure.testdrive;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDriveDao extends JpaRepository<TestDrive, Integer> {

	Collection<TestDrive> findByUserId(Integer userId);

}
