package com.manuel.forum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuel.forum.model.SurveyOption;
import com.manuel.forum.repository.SurveyOptionRepository;

@Service
public class SurveyOptionImpl implements BaseService<SurveyOption>, SurveyOptionService {

	@Autowired
	private SurveyOptionRepository surveyOptionRepository;

	@Override
	public List<SurveyOption> findAll() throws Exception {
		// TODO Auto-generated method stub
		return surveyOptionRepository.findAll();
	}

	@Override
	public Optional<SurveyOption> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return surveyOptionRepository.findById(id);
	}

	@Override
	public SurveyOption save(SurveyOption entity) throws Exception {
		// TODO Auto-generated method stub
		return surveyOptionRepository.save(entity);
	}
}
