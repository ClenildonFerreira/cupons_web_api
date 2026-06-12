package com.amor.domain.coupon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void shouldCreateNewCouponWithAvailableStatus() {
        Coupon coupon = new Coupon("Vale Jantar Especial", "Jantar no seu restaurante favorito", "dinner-icon");
        
        assertNotNull(coupon.getId());
        assertEquals("Vale Jantar Especial", coupon.getTitle());
        assertEquals("Jantar no seu restaurante favorito", coupon.getDescription());
        assertEquals(CouponStatus.AVAILABLE, coupon.getStatus());
        assertNull(coupon.getRedemptionDate());
    }

    @Test
    void shouldRedeemCouponSuccessfully() {
        Coupon coupon = new Coupon("Vale Cinema", "Vamos ver um filme", "movie-icon");
        coupon.redeem();
        
        assertEquals(CouponStatus.USED, coupon.getStatus());
        assertNotNull(coupon.getRedemptionDate());
    }

    @Test
    void shouldNotRedeemAlreadyUsedCoupon() {
        Coupon coupon = new Coupon("Vale Massagem", "Massagem relaxante", "spa-icon");
        coupon.redeem();
        
        assertThrows(IllegalStateException.class, coupon::redeem);
    }
    
    @Test
    void shouldNotCreateCouponWithoutTitle() {
        assertThrows(IllegalArgumentException.class, () -> new Coupon("", "Desc", "icon"));
        assertThrows(IllegalArgumentException.class, () -> new Coupon(null, "Desc", "icon"));
    }
}
