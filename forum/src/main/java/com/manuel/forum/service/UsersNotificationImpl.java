package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.UsersNotification;
import com.manuel.forum.repository.UsersNotificationRepository;

@Service
public class UsersNotificationImpl implements BaseService<UsersNotification>, UsersNotificationService {

	@Autowired
	private UsersNotificationRepository usersNotificationRepository;

	@Override
	public List<UsersNotification> findAll() throws Exception {
		// TODO Auto-generated method stub
		return usersNotificationRepository.findAll();
	}

	@Override
	public Optional<UsersNotification> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usersNotificationRepository.findById(id);
	}

	@Override
	public UsersNotification save(UsersNotification entity) throws Exception {
		// TODO Auto-generated method stub
		return usersNotificationRepository.save(entity);
	}

}
