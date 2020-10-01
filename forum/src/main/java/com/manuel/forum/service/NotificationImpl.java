package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.Notification;
import com.manuel.forum.repository.NotificationRepository;

@Service
public class NotificationImpl implements BaseService<Notification>, NotificationService {
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public List<Notification> findAll() throws Exception {
		// TODO Auto-generated method stub
		return notificationRepository.findAll();
	}

	@Override
	public Optional<Notification> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return notificationRepository.findById(id);
	}

	@Override
	public Notification save(Notification entity) throws Exception {
		// TODO Auto-generated method stub
		return notificationRepository.save(entity);
	}

}
