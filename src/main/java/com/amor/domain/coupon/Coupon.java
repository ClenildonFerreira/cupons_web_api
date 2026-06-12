package com.amor.domain.coupon;

import java.time.LocalDateTime;
import java.util.UUID;

public class Coupon {
    private final UUID id;
    private final String title;
    private final String description;
    private final String icon;
    private LocalDateTime redemptionDate;
    private CouponStatus status;

    public Coupon(String title, String description, String icon) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.status = CouponStatus.AVAILABLE;
    }

    public void redeem() {
        if (this.status == CouponStatus.USED) {
            throw new IllegalStateException("Coupon already used");
        }
        this.status = CouponStatus.USED;
        this.redemptionDate = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }
    public LocalDateTime getRedemptionDate() { return redemptionDate; }
    public CouponStatus getStatus() { return status; }
}
