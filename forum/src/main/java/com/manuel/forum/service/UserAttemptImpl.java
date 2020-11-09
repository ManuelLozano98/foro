package com.manuel.forum.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.UserAttempt;
import com.manuel.forum.repository.UserAttemptRepository;

@Service
public class UserAttemptImpl implements BaseService<UserAttempt>, UserAttemptService {

	@Autowired
	private UserAttemptRepository userAttemptRepository;

	private final int NUM_MAX_FAILED_ATTEMPTS = 4;

	@Override
	public List<UserAttempt> findAll() throws Exception {
		// TODO Auto-generated method stub
		return userAttemptRepository.findAll();
	}

	@Override
	public Optional<UserAttempt> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userAttemptRepository.findById(id);
	}

	@Override
	public UserAttempt save(UserAttempt entity) throws Exception {
		// TODO Auto-generated method stub
		return userAttemptRepository.save(entity);
	}

	@Override
	public void updateFailAttempts(String IP) {
		// TODO Auto-generated method stub

		UserAttempt userAttempts = getUserAttempts(IP);
		userAttempts.setAttempts(userAttempts.getAttempts() + 1);
		userAttempts.setLastModified(LocalDateTime.now());
		userAttemptRepository.save(userAttempts);
	}

	@Override
	public void resetFailAttempts(String IP) throws Exception {
		// TODO Auto-generated method stub

		UserAttempt userAttempts = getUserAttempts(IP);
		userAttempts.setAttempts(0);
		userAttempts.setTimeBlockInMinutes(0);
		userAttemptRepository.save(userAttempts);

	}

	@Override
	public UserAttempt getUserAttempts(String IP) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		UserAttempt userAttempts = null;
		if (userAttemptRepository.findByIP(IP) == null) {
			userAttempts = new UserAttempt(IP);
			userAttemptRepository.save(userAttempts);
		} else {	
			return userAttemptRepository.findByIP(IP);
		}

		return userAttempts;
	}

	@Override
	public boolean isNumberMaxAttempts(String IP) {
		// TODO Auto-generated method stub
		boolean maxAttempts = false;
		if (NUM_MAX_FAILED_ATTEMPTS == getUserAttempts(IP).getAttempts()) {
			maxAttempts = true;
		}
		return maxAttempts;
	}

}
