package com.gabeDev.hexagonalAPI.domain.port.in;

import com.gabeDev.hexagonalAPI.domain.model.Produce;

import java.util.List;
import java.util.UUID;

public interface ProduceQueries {

    Produce retrieveProduce(UUID id);
    List<Produce> retrieveAllProduce();
}
