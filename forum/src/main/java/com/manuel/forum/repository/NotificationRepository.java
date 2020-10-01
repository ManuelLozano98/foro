package com.manuel.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuel.forum.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
