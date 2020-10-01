package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

	List<T> findAll() throws Exception;

	Optional<T> findById(Integer id) throws Exception;

	T save(T entity) throws Exception;

}
