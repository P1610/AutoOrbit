package com.project.carventure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email = :email")

	User findUserByEmail(@Param("email") String email);

	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
	User findByVerificationCode(String code);

}
