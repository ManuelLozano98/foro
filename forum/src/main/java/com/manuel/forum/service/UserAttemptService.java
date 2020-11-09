package com.manuel.forum.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.manuel.forum.model.UserAttempt;

public interface UserAttemptService {

	void updateFailAttempts(String IP) throws UsernameNotFoundException;

	void resetFailAttempts(String IP) throws Exception;

	UserAttempt getUserAttempts(String IP) throws UsernameNotFoundException;
	
	boolean isNumberMaxAttempts(String IP);
}
