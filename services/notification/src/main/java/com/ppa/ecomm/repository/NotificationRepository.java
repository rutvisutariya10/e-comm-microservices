package com.ppa.ecomm.repository;

import com.ppa.ecomm.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
