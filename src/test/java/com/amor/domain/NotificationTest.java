package com.amor.domain;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {
    @Test
    void shouldCreateNotificationAsUnread() {
        UUID userId = UUID.randomUUID();
        Notification notification = new Notification("You have a new coupon!", userId);
        assertNotNull(notification.getId());
        assertEquals("You have a new coupon!", notification.getMessage());
        assertFalse(notification.isReadStatus());
        assertEquals(userId, notification.getUserId());
        assertNotNull(notification.getCreatedAt());
    }

    @Test
    void shouldMarkAsRead() {
        Notification notification = new Notification("Msg", UUID.randomUUID());
        notification.markAsRead();
        assertTrue(notification.isReadStatus());
    }
}
