package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.TopicsComment;
import com.manuel.forum.repository.TopicsCommentRepository;

@Service
public class TopicsCommentImpl implements BaseService<TopicsComment>, TopicsCommentService {

	@Autowired
	private TopicsCommentRepository topicsCommentRepository;

	@Override
	public List<TopicsComment> findAll() throws Exception {
		// TODO Auto-generated method stub
		return topicsCommentRepository.findAll();
	}

	@Override
	public Optional<TopicsComment> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return topicsCommentRepository.findById(id);
	}

	@Override
	public TopicsComment save(TopicsComment entity) throws Exception {
		// TODO Auto-generated method stub
		return topicsCommentRepository.save(entity);
	}

}
