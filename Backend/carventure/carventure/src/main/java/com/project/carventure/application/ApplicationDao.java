package com.project.carventure.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.carventure.user.User;

public interface ApplicationDao extends JpaRepository<Application, Integer> {

	@Query("SELECT a FROM Application a WHERE a.status = 'Pending' OR a.status = 'Approved'")
	List<Application> findPendingOrApprovedApplications();

}
