package com.example.awssqs.web.controller;

import com.example.awssqs.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications/v2")
@CrossOrigin
public class NotificationControllerV2 {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<?> getNotificationWithRecipientByUid(@PathVariable String uid){
        return notificationService.getNotificationWithRecipientByUid(uid);
    }
}
