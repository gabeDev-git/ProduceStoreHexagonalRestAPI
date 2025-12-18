package com.gabeDev.hexagonalAPI.adapter.persistence.jparepository;

import com.gabeDev.hexagonalAPI.adapter.persistence.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaSaleRepository extends JpaRepository<SaleEntity, Long> {
    Optional<SaleEntity> findBySaleId(UUID id);
    void deleteBySaleId(UUID id);
    List<SaleEntity> findByCreatedAtAfter(Instant instant);

}
