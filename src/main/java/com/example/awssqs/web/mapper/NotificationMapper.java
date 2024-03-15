package com.example.awssqs.web.mapper;

import com.example.awssqs.entity.Notification;
import com.example.awssqs.web.dto.NotificationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDto map(Notification notification);
    @InheritInverseConfiguration
    Notification map(NotificationDto notificationDto);
}
