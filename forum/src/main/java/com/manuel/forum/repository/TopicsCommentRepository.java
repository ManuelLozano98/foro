package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.TopicsComment;

@Repository
public interface TopicsCommentRepository extends JpaRepository<TopicsComment, Integer> {

}
