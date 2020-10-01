package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.ImagesComment;

@Repository
public interface ImagesCommentRepository extends JpaRepository<ImagesComment, Integer> {

}
