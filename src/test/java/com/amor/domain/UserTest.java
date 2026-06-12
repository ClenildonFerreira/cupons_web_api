package com.amor.domain;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void shouldCreateUserSuccessfully() {
        User user = new User("admin", "secret", UserRole.ADMIN);
        assertNotNull(user.getId());
        assertEquals("admin", user.getUsername());
        assertEquals(UserRole.ADMIN, user.getRole());
    }

    @Test
    void shouldSetRelationshipInfo() {
        User user = new User("partner", "secret", UserRole.PARTNER);
        user.setRelationshipInfo("Jane Doe", LocalDate.of(2020, 1, 1));
        assertEquals("Jane Doe", user.getPartnerName());
        assertEquals(LocalDate.of(2020, 1, 1), user.getStartDate());
    }
}
