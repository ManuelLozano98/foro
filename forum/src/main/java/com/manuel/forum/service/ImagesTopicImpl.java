package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.ImagesTopic;
import com.manuel.forum.repository.ImagesTopicRepository;

@Service
public class ImagesTopicImpl implements BaseService<ImagesTopic>, ImagesTopicService {

	@Autowired
	private ImagesTopicRepository imagesTopicRepository;

	@Override
	public List<ImagesTopic> findAll() throws Exception {
		// TODO Auto-generated method stub
		return imagesTopicRepository.findAll();
	}

	@Override
	public Optional<ImagesTopic> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return imagesTopicRepository.findById(id);
	}

	@Override
	public ImagesTopic save(ImagesTopic entity) throws Exception {
		// TODO Auto-generated method stub
		return imagesTopicRepository.save(entity);
	}

}
