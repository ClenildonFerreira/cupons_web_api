package com.amor.domain.coupon;

import com.amor.domain.Coupon;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {
    List<Coupon> findAll();
    Optional<Coupon> findById(UUID id);
    Coupon save(Coupon coupon);
}
