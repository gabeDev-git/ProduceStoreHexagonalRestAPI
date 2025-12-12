package com.gabeDev.hexagonalAPI.adapter.persistence.jparepository;

import com.gabeDev.hexagonalAPI.adapter.persistence.entity.ProduceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaProduceRepository extends JpaRepository<ProduceEntity, Long> {
    Optional<ProduceEntity> findByProduceId(UUID produceId);
    void deleteByProduceId(UUID produceId);
}
