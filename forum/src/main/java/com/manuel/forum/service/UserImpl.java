package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.User;
import com.manuel.forum.repository.UserRepository;

@Service
public class UserImpl implements BaseService<User>, UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User save(User entity) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

}
