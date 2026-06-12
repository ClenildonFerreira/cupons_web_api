package com.amor.application.usecases.coupon;

import com.amor.application.dto.CouponDTO;
import com.amor.domain.coupon.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListCouponsUseCase {
    private final CouponRepository repository;

    public List<CouponDTO> execute() {
        return repository.findAll().stream()
                .map(CouponDTO::fromDomain)
                .collect(Collectors.toList());
    }
}
