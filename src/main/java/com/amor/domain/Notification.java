package com.amor.domain;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Notification {
    private UUID id;
    private String message;
    private LocalDateTime createdAt;
    private boolean readStatus;
    private UUID userId;

    public Notification(String message, UUID userId) {
        if (message == null || message.isBlank()) throw new IllegalArgumentException("Message cannot be blank");
        this.id = UUID.randomUUID();
        this.message = message;
        this.createdAt = LocalDateTime.now();
        this.readStatus = false;
        this.userId = userId;
    }

    public void markAsRead() {
        this.readStatus = true;
    }
}
