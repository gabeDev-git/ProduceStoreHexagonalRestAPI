package com.gabeDev.hexagonalAPI.domain.port.in;

import com.gabeDev.hexagonalAPI.domain.model.Sale;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public interface SaleQueries {

    Sale retrieveSale(UUID id);
    List<Sale> retrieveAll();
    List<Sale> retrieveSalesByTimeframe(Duration duration);

}
