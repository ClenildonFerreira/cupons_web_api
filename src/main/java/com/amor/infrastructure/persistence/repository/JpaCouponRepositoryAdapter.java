package com.amor.infrastructure.persistence.repository;

import com.amor.domain.Coupon;
import com.amor.domain.CouponStatus;
import com.amor.domain.coupon.CouponRepository;
import com.amor.infrastructure.persistence.entity.CouponEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaCouponRepositoryAdapter implements CouponRepository {

    private final SpringDataCouponRepository repository;

    @Override
    public List<Coupon> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Coupon> findById(UUID id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public Coupon save(Coupon coupon) {
        CouponEntity entity = toEntity(coupon);
        CouponEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    private Coupon toDomain(CouponEntity entity) {
        // Reflection or setter approach to reconstruct the Domain object since it encapsulates its state
        try {
            Coupon coupon = new Coupon(entity.getTitle(), entity.getDescription(), entity.getIcon());
            // Need to set ID, status, redeemDate via reflection or add package-private constructors.
            // For simplicity and to respect DDD encapsulation, we use reflection to set ID and other fields, 
            // or we add a specific reconstructor in Coupon. Let's add a constructor in Coupon for reconstruction.
            java.lang.reflect.Field idField = Coupon.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(coupon, entity.getId());

            java.lang.reflect.Field statusField = Coupon.class.getDeclaredField("status");
            statusField.setAccessible(true);
            statusField.set(coupon, entity.getStatus());

            java.lang.reflect.Field dateField = Coupon.class.getDeclaredField("redeemDate");
            dateField.setAccessible(true);
            dateField.set(coupon, entity.getRedeemDate());

            return coupon;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping entity to domain", e);
        }
    }

    private CouponEntity toEntity(Coupon domain) {
        CouponEntity entity = new CouponEntity();
        entity.setId(domain.getId());
        entity.setTitle(domain.getTitle());
        entity.setDescription(domain.getDescription());
        entity.setIcon(domain.getIcon());
        entity.setStatus(domain.getStatus());
        entity.setRedeemDate(domain.getRedeemDate());
        return entity;
    }
}
