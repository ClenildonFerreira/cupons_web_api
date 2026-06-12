package com.amor.domain;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Achievement {
    private UUID id;
    private String title;
    private String description;
    private String icon;
    private boolean unlocked;
    private LocalDateTime unlockedAt;

    public Achievement(String title, String description, String icon) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be blank");
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.unlocked = false;
    }

    public void unlock() {
        if (this.unlocked) {
            throw new IllegalStateException("Achievement is already unlocked");
        }
        this.unlocked = true;
        this.unlockedAt = LocalDateTime.now();
    }
}
