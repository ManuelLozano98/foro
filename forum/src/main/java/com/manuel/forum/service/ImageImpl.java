package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.Image;
import com.manuel.forum.repository.ImageRepository;

@Service
public class ImageImpl implements BaseService<Image>, ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public List<Image> findAll() throws Exception {
		// TODO Auto-generated method stub
		return imageRepository.findAll();
	}

	@Override
	public Optional<Image> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return imageRepository.findById(id);
	}

	@Override
	public Image save(Image entity) throws Exception {
		// TODO Auto-generated method stub
		return imageRepository.save(entity);
	}

}
