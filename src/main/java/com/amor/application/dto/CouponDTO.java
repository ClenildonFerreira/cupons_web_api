package com.amor.application.dto;

import com.amor.domain.Coupon;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CouponDTO {
    private UUID id;
    private String title;
    private String description;
    private String icon;
    private String status;
    private LocalDateTime redeemDate;

    public static CouponDTO fromDomain(Coupon coupon) {
        CouponDTO dto = new CouponDTO();
        dto.setId(coupon.getId());
        dto.setTitle(coupon.getTitle());
        dto.setDescription(coupon.getDescription());
        dto.setIcon(coupon.getIcon());
        dto.setStatus(coupon.getStatus().name());
        dto.setRedeemDate(coupon.getRedeemDate());
        return dto;
    }
}
