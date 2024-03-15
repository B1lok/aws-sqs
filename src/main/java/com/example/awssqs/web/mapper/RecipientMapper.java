package com.example.awssqs.web.mapper;

import com.example.awssqs.entity.Notification;
import com.example.awssqs.entity.Recipient;
import com.example.awssqs.web.dto.NotificationDto;
import com.example.awssqs.web.dto.RecipientDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {
    RecipientDto map(Recipient recipient);
    @InheritInverseConfiguration
    Recipient map(RecipientDto recipientDto);
}
