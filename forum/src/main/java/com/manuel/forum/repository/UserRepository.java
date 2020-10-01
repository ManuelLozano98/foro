package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
