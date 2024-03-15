package com.example.awssqs.repository;

import com.example.awssqs.entity.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends R2dbcRepository<Notification, String> {
    Flux<Notification> findAllByRecipientUid(String uid);
}
