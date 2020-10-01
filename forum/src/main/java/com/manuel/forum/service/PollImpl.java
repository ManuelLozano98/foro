package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.Poll;
import com.manuel.forum.repository.PollRepository;

@Service
public class PollImpl implements BaseService<Poll>, PollService {

	@Autowired
	private PollRepository pollRepository;
	@Override
	public List<Poll> findAll() throws Exception {
		// TODO Auto-generated method stub
		return pollRepository.findAll();
	}

	@Override
	public Optional<Poll> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pollRepository.findById(id);
	}

	@Override
	public Poll save(Poll entity) throws Exception {
		// TODO Auto-generated method stub
		return pollRepository.save(entity);
	}

}
