package com.gabeDev.hexagonalAPI.application.service;
import com.gabeDev.hexagonalAPI.domain.model.Produce;
import com.gabeDev.hexagonalAPI.domain.port.in.ProduceCommands;
import com.gabeDev.hexagonalAPI.domain.port.in.ProduceQueries;
import com.gabeDev.hexagonalAPI.domain.port.out.ProduceRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProduceService implements ProduceCommands, ProduceQueries {

    ProduceRepositoryPort produceRepositoryPort;

    public ProduceService(ProduceRepositoryPort produceRepositoryPort){
        this.produceRepositoryPort = produceRepositoryPort;
    }


    @Override
    public Produce createNew(Produce produce) {
        return produceRepositoryPort.save(produce);
    }

    @Override
    public Produce restockProduce(UUID id, int amount) {
        Produce produce = retrieveProduce(id);
        produce.increaseQuantity(amount);
        return produceRepositoryPort.save(produce);
    }

    @Override
    public Produce removeOrSellStock(UUID id, int amount) {
        Produce produce = retrieveProduce(id);
        produce.decreaseQuantity(amount);
        return produceRepositoryPort.save(produce);
    }

    @Override
    public Produce changeName(UUID id, String name) {
        Produce produce = retrieveProduce(id);
        produce.setName(name);
        return produceRepositoryPort.save(produce);
    }

    @Override
    public Produce changePrice(UUID id, BigDecimal amount) {
        Produce produce = retrieveProduce(id);
        produce.setPrice(amount);
        return produceRepositoryPort.save(produce);
    }

    @Override
    public void removeProduce(UUID id) {
        produceRepositoryPort.deleteById(id);
    }

    @Override
    public Produce retrieveProduce(UUID id) {
        return produceRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Produce with id " + id + "not found"));
    }

    @Override
    public List<Produce> retrieveAllProduce() {
        return produceRepositoryPort.findAll();
    }
}
