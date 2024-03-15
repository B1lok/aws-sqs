package com.example.awssqs.service;

import com.example.awssqs.entity.Notification;
import com.example.awssqs.entity.Recipient;
import com.example.awssqs.repository.NotificationRepository;
import com.example.awssqs.repository.RecipientRepository;
import com.example.awssqs.web.dto.RecipientDto;
import com.example.awssqs.web.mapper.RecipientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;
    private final NotificationRepository notificationRepository;

    public Mono<RecipientDto> getRecipientWithNotificationByUid(String uid){
        return Mono.zip(
                recipientRepository.findById(uid),
                notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(elems -> {
                    Recipient recipient = elems.getT1();
                    List<Notification> notificationList = elems.getT2();
                    recipient.setNotifications(notificationList);
                    return recipientMapper.map(recipient);
                });
    }
}
