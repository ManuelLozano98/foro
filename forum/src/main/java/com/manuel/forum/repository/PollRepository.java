package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {

}
