package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.ImagesComment;
import com.manuel.forum.repository.ImagesCommentRepository;

@Service
public class ImagesCommentImpl implements BaseService<ImagesComment>, ImagesCommentService {

	@Autowired
	private ImagesCommentRepository imagesCommentRepository;

	@Override
	public List<ImagesComment> findAll() throws Exception {
		// TODO Auto-generated method stub
		return imagesCommentRepository.findAll();
	}

	@Override
	public Optional<ImagesComment> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return imagesCommentRepository.findById(id);
	}

	@Override
	public ImagesComment save(ImagesComment entity) throws Exception {
		// TODO Auto-generated method stub
		return imagesCommentRepository.save(entity);
	}

}
