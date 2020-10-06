package com.manuel.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

//import com.manuel.forum.model.User;
import com.manuel.forum.repository.UserRepository;

public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetailsImpl() {

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<com.manuel.forum.model.User> userDB = userRepository.getUserByUserName(username);
		if (username == null || !userDB.isPresent()) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		// At this point we know the user exists
		UserBuilder builder = null;
		builder = User.withUsername(username);
		builder.password(userDB.get().getPassword());
		builder.roles(userDB.get().getRole());
		return builder.build();
	}

}
