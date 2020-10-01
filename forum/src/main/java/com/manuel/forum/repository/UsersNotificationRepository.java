package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.UsersNotification;

@Repository
public interface UsersNotificationRepository extends JpaRepository<UsersNotification, Integer> {

}
