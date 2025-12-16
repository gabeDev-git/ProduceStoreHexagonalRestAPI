package com.gabeDev.hexagonalAPI.domain.port.in;

import com.gabeDev.hexagonalAPI.domain.model.PaymentMethod;
import com.gabeDev.hexagonalAPI.domain.model.Sale;
import com.gabeDev.hexagonalAPI.domain.model.SaleItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface SaleCommands {

    Sale createNew(HashMap<UUID, Integer> checkout, PaymentMethod paymentMethod);
    BigDecimal calculateTotal(List<SaleItem> checkout);
    void deleteSale(UUID id);
}
