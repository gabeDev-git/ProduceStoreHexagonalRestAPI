package com.gabeDev.hexagonalAPI.domain.port.out;

import com.gabeDev.hexagonalAPI.domain.model.Sale;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaleRepositoryPort {

    Sale save(Sale sale);
    List<Sale> findAll();
    List<Sale> findByTimeframe(Instant timeframe);
    Optional<Sale> findById(UUID id);
    void deleteById(UUID id);


}
