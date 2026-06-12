package com.amor.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void shouldCreateCouponWithAvailableStatus() {
        Coupon coupon = new Coupon("Vale Jantar", "Jantar romântico", "dinner_icon");
        
        assertNotNull(coupon.getId());
        assertEquals("Vale Jantar", coupon.getTitle());
        assertEquals(CouponStatus.AVAILABLE, coupon.getStatus());
        assertNull(coupon.getRedeemDate());
    }

    @Test
    void shouldRedeemCouponSuccessfully() {
        Coupon coupon = new Coupon("Vale Jantar", "Jantar", "icon");
        
        coupon.redeem();
        
        assertEquals(CouponStatus.REDEEMED, coupon.getStatus());
        assertNotNull(coupon.getRedeemDate());
    }

    @Test
    void shouldNotAllowRedeemingAlreadyRedeemedCoupon() {
        Coupon coupon = new Coupon("Vale", "Desc", "icon");
        coupon.redeem();
        
        IllegalStateException exception = assertThrows(IllegalStateException.class, coupon::redeem);
        assertEquals("Coupon is already redeemed", exception.getMessage());
    }
    
    @Test
    void shouldThrowExceptionWhenTitleIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Coupon("", "Desc", "icon"));
        assertThrows(IllegalArgumentException.class, () -> new Coupon(null, "Desc", "icon"));
    }
}
