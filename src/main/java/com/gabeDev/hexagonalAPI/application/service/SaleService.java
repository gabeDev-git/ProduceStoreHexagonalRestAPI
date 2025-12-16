package com.gabeDev.hexagonalAPI.application.service;

import com.gabeDev.hexagonalAPI.domain.model.PaymentMethod;
import com.gabeDev.hexagonalAPI.domain.model.Sale;
import com.gabeDev.hexagonalAPI.domain.model.SaleItem;
import com.gabeDev.hexagonalAPI.domain.port.in.ProduceQueries;
import com.gabeDev.hexagonalAPI.domain.port.in.SaleCommands;
import com.gabeDev.hexagonalAPI.domain.port.in.SaleQueries;
import com.gabeDev.hexagonalAPI.domain.port.out.SaleRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SaleService implements SaleCommands, SaleQueries {

    private final SaleRepositoryPort saleRepositoryPort;
    private final ProduceQueries produceQueries;

    public SaleService(SaleRepositoryPort saleRepositoryPort, ProduceQueries produceQueries){
        this.saleRepositoryPort = saleRepositoryPort;
        this.produceQueries = produceQueries;
    }

    @Override
    public Sale createNew(HashMap<UUID, Integer> checkout, PaymentMethod paymentMethod) {
        List<SaleItem> checkoutList = new ArrayList<>();

        for(UUID uuid : checkout.keySet()){
            var produce = produceQueries.retrieveProduce(uuid);
            var saleItem = new SaleItem(produce.getProduceId(), produce.getName(), produce.getPrice(),
                    checkout.get(uuid));
            checkoutList.add(saleItem);
        }
        BigDecimal total = calculateTotal(checkoutList);

        Sale sale = new Sale(UUID.randomUUID(), checkoutList, total, paymentMethod);

        return saleRepositoryPort.save(sale);

    }

    @Override
    public BigDecimal calculateTotal(List<SaleItem> checkout) {
       return Sale.getTotal(checkout);
    }

    @Override
    public void deleteSale(UUID id) {
        saleRepositoryPort.deleteById(id);
    }

    @Override
    public Sale retrieveSale(UUID id) {
        return saleRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    @Override
    public List<Sale> retrieveAll() {
        return saleRepositoryPort.findAll();
    }

    @Override
    public List<Sale> retrieveSalesByTimeframe(Duration duration) {
        Instant timeframe = Instant.now().minus(duration);
        return saleRepositoryPort.findByTimeframe(timeframe);
    }
}
