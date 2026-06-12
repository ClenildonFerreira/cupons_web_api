package com.amor.domain;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Coupon {
    private UUID id;
    private String title;
    private String description;
    private String icon;
    private CouponStatus status;
    private LocalDateTime redeemDate;

    public Coupon(String title, String description, String icon) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.status = CouponStatus.AVAILABLE;
    }

    public void redeem() {
        if (this.status == CouponStatus.REDEEMED) {
            throw new IllegalStateException("Coupon is already redeemed");
        }
        this.status = CouponStatus.REDEEMED;
        this.redeemDate = LocalDateTime.now();
    }
}
