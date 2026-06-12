package com.amor.infrastructure.web;

import com.amor.application.dto.CouponDTO;
import com.amor.application.usecases.coupon.ListCouponsUseCase;
import com.amor.application.usecases.coupon.RedeemCouponUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.OPTIONS})
@Tag(name = "Coupons", description = "Coupon management APIs")
public class CouponController {

    private final ListCouponsUseCase listCouponsUseCase;
    private final RedeemCouponUseCase redeemCouponUseCase;

    @GetMapping
    @Operation(summary = "List all coupons", description = "Retrieves a list of all available and redeemed coupons.")
    public ResponseEntity<List<CouponDTO>> listCoupons() {
        return ResponseEntity.ok(listCouponsUseCase.execute());
    }

    @PutMapping("/{id}/redeem")
    @Operation(summary = "Redeem a coupon", description = "Marks a specific coupon as redeemed.")
    public ResponseEntity<CouponDTO> redeemCoupon(@PathVariable UUID id) {
        return ResponseEntity.ok(redeemCouponUseCase.execute(id));
    }
}
