package com.amor.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AchievementTest {
    @Test
    void shouldCreateLockedAchievement() {
        Achievement achievement = new Achievement("First Coupon", "Redeemed first coupon", "medal");
        assertFalse(achievement.isUnlocked());
        assertNull(achievement.getUnlockedAt());
    }

    @Test
    void shouldUnlockAchievement() {
        Achievement achievement = new Achievement("First", "Desc", "icon");
        achievement.unlock();
        assertTrue(achievement.isUnlocked());
        assertNotNull(achievement.getUnlockedAt());
    }
}
