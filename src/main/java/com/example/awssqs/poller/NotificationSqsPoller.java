package com.example.awssqs.poller;

import com.example.awssqs.entity.Notification;
import com.example.awssqs.repository.NotificationRepository;
import com.example.awssqs.web.dto.NotificationDto;
import com.example.awssqs.web.mapper.NotificationMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationSqsPoller {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener("${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDto notificationDto){
        var notification = notificationMapper.map(notificationDto);
        notificationRepository.save(notification).subscribe();
    }

}
