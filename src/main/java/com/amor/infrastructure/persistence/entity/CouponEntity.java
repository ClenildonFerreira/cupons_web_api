package com.amor.infrastructure.persistence.entity;

import com.amor.domain.CouponStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "coupons")
@Getter
@Setter
public class CouponEntity {
    @Id
    private UUID id;
    
    private String title;
    private String description;
    private String icon;
    
    @Enumerated(EnumType.STRING)
    private CouponStatus status;
    
    @Column(name = "redeem_date")
    private LocalDateTime redeemDate;
}
