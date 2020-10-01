package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
}
