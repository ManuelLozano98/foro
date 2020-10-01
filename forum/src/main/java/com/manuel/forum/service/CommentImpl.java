package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.Comment;
import com.manuel.forum.repository.CommentRepository;

@Service
public class CommentImpl implements BaseService<Comment>, CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> findAll() throws Exception {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

	@Override
	public Optional<Comment> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return commentRepository.findById(id);
	}

	@Override
	public Comment save(Comment entity) throws Exception {
		// TODO Auto-generated method stub
		return commentRepository.save(entity);
	}

}
