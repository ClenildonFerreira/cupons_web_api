package com.amor.infrastructure.persistence.repository;

import com.amor.infrastructure.persistence.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataCouponRepository extends JpaRepository<CouponEntity, UUID> {
}
