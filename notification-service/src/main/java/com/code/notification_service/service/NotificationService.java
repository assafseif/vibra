package com.code.notification_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.code.notification_service.order.ArtistPlacedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    // @Autowired
    // private JavaMailSender javaMailSender;

    @KafkaListener(id = "foo",topics = "music-placed")
    public void listen(ArtistPlacedEvent artistPlacedEvent) {
        System.out.println("Payload "+artistPlacedEvent);
    }

}
