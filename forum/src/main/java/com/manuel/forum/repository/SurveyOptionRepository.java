package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.SurveyOption;

@Repository
public interface SurveyOptionRepository extends JpaRepository<SurveyOption, Integer> {

}
