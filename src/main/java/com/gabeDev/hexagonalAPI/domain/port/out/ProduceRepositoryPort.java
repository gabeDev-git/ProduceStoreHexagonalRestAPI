package com.gabeDev.hexagonalAPI.domain.port.out;

import com.gabeDev.hexagonalAPI.domain.model.Produce;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProduceRepositoryPort {

    Produce save(Produce produce);
    List<Produce> findAll();
    Optional<Produce> findById(UUID produceId);
    void deleteById(UUID produceId);
}
