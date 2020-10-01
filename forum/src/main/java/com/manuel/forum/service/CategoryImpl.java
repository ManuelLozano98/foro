package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.Category;
import com.manuel.forum.repository.CategoryRepository;

@Service
public class CategoryImpl implements BaseService<Category>, CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category entity) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.save(entity);
	}

}
