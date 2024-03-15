package com.example.awssqs.web.controller;

import com.example.awssqs.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications/v1")
@CrossOrigin
public class NotificationControllerV1 {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<?> getNotificationByUid(@PathVariable String uid){
        return notificationService.getNotificationByUid(uid);
    }
}
