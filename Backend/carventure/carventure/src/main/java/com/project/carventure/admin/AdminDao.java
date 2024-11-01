package com.project.carventure.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.carventure.user.User;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	@Query("SELECT a FROM Admin a WHERE a.email = :email")

	Admin findAdminByEmail(@Param("email") String email);
}
