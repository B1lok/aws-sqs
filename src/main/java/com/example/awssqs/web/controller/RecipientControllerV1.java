package com.example.awssqs.web.controller;

import com.example.awssqs.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/recipient/v1")
@RestController
@CrossOrigin
public class RecipientControllerV1 {
    private final RecipientService recipientService;

    @GetMapping()
    public String getTest(){
        return "TEST 8080";
    }

    @GetMapping("/{uid}")
    public Mono<?> findRecipientWithNotificationByUid(@PathVariable String uid){
        return recipientService.getRecipientWithNotificationByUid(uid);
    }
}
