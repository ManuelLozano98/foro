package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
