package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.Topic;
import com.manuel.forum.repository.TopicRepository;

@Service
public class TopicImpl implements BaseService<Topic>, TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> findAll() throws Exception {
		// TODO Auto-generated method stub
		return topicRepository.findAll();
	}

	@Override
	public Optional<Topic> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return topicRepository.findById(id);
	}

	@Override
	public Topic save(Topic entity) throws Exception {
		// TODO Auto-generated method stub
		return topicRepository.save(entity);
	}

}
