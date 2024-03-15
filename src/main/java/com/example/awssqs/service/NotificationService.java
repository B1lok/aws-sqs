package com.example.awssqs.service;

import com.example.awssqs.repository.NotificationRepository;
import com.example.awssqs.repository.RecipientRepository;
import com.example.awssqs.web.dto.NotificationDto;
import com.example.awssqs.web.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Month;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final RecipientRepository recipientRepository;

    public Mono<NotificationDto> getNotificationByUid(String uid){
        return notificationRepository.findById(uid)
                .map(notificationMapper::map);
    }

    public Mono<NotificationDto> getNotificationWithRecipientByUid(String uid){
        return notificationRepository.findById(uid)
                .flatMap(notification -> recipientRepository.findById(notification.getRecipientUid())
                        .map(recipient -> {
                            notification.setRecipient(recipient);
                            return notification;
                        }).map(notificationMapper::map));
    }
}
