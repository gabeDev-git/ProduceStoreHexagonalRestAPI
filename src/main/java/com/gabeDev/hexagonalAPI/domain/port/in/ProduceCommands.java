package com.gabeDev.hexagonalAPI.domain.port.in;
import com.gabeDev.hexagonalAPI.domain.model.Produce;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProduceCommands {

    Produce createNew(Produce produce);
    Produce restockProduce(UUID id, int amount);
    Produce removeOrSellStock(UUID id ,int amount);
    Produce changeName(UUID id, String name);
    Produce changePrice(UUID id, BigDecimal amount);
    void removeProduce(UUID id);

}
