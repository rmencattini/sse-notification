package com.poc.notification.sse.api;

import com.poc.notification.sse.models.Notification;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping("/subscribe/{id}")
    public Flux<ServerSentEvent<Notification>> subscribe() {
        return Flux.interval(Duration.of(2, ChronoUnit.SECONDS))
            .map(i -> ServerSentEvent.<Notification>builder()
                .id(String.valueOf(i))
                .event("notification")
                .data(new Notification("some tpye", "body n°: " + i))
                .retry(Duration.of(1, ChronoUnit.SECONDS))
                .build())
            .takeWhile(toto -> true);
    }
}
