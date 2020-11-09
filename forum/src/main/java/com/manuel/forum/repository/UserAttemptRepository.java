package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.UserAttempt;

@Repository
public interface UserAttemptRepository extends JpaRepository<UserAttempt, Integer> {

	@Query(value = "SELECT u FROM UserAttempt u WHERE u.ip = :IP")
	UserAttempt findByIP(@Param("IP") String IP);

	
	
	
	
}
