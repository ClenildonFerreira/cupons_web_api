package com.amor.application.usecases.coupon;

import com.amor.application.dto.CouponDTO;
import com.amor.domain.Coupon;
import com.amor.domain.coupon.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RedeemCouponUseCase {
    private final CouponRepository repository;

    public CouponDTO execute(UUID id) {
        Coupon coupon = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Coupon not found"));

        coupon.redeem();
        Coupon saved = repository.save(coupon);
        
        return CouponDTO.fromDomain(saved);
    }
}
