package com.gabeDev.hexagonalAPI.domain.port.out;

import com.gabeDev.hexagonalAPI.domain.model.Sale;

import java.util.List;
import java.util.UUID;

public interface SaleRepositoryPort {

    Sale save(Sale sale);
    List<Sale> findAll();
    Sale findById(UUID id);
    Sale deleteById(UUID id);


}
