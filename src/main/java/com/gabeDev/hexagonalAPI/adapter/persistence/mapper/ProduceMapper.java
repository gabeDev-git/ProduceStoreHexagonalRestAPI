package com.gabeDev.hexagonalAPI.adapter.persistence.mapper;

import com.gabeDev.hexagonalAPI.adapter.persistence.entity.ProduceEntity;
import com.gabeDev.hexagonalAPI.application.dto.CreateProduceRequest;
import com.gabeDev.hexagonalAPI.application.dto.ProduceDetails;
import com.gabeDev.hexagonalAPI.domain.model.Produce;

public class ProduceMapper {

    public static ProduceEntity toEntity(Produce produce){
        ProduceEntity entity = new ProduceEntity();
        entity.setProduceId(produce.getProduceId());
        entity.setName(produce.getName());
        entity.setPrice(produce.getPrice());
        entity.setQuantity(produce.getQuantity());

        return entity;
    }

    public static Produce toDomain(ProduceEntity entity){
        Produce produce = new Produce();
        produce.setProduceId(entity.getProduceId());
        produce.setName(entity.getName());
        produce.setPrice(entity.getPrice());
        produce.setQuantity(entity.getQuantity());

        return produce;
    }

    public static ProduceDetails toProduceDetails(ProduceEntity produceEntity){
        return new ProduceDetails(produceEntity.getProduceId(), produceEntity.getName(),
                produceEntity.getPrice(), produceEntity.getQuantity(),
                produceEntity.getCreatedAt(), produceEntity.getUpdatedAt());
    }

    public static Produce toDomainFromDto(CreateProduceRequest request){
        Produce produce = new Produce();
        produce.setName(request.name());
        produce.setPrice(request.price());
        produce.setQuantity(request.quantity());

        return produce;
    }
}
