package com.gabeDev.hexagonalAPI.adapter.persistence.repositoryimpl;

import com.gabeDev.hexagonalAPI.adapter.persistence.jparepository.JpaProduceRepository;
import com.gabeDev.hexagonalAPI.adapter.persistence.mapper.ProduceMapper;
import com.gabeDev.hexagonalAPI.domain.model.Produce;
import com.gabeDev.hexagonalAPI.domain.port.out.ProduceRepositoryPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProduceRepositoryImpl implements ProduceRepositoryPort {

    private final JpaProduceRepository jpaProduceRepository;

    public ProduceRepositoryImpl(JpaProduceRepository jpaProduceRepository){
        this.jpaProduceRepository = jpaProduceRepository;
    }

    @Override
    public Produce save(Produce produce) {
        var entity = ProduceMapper.toEntity(produce);
        entity.setUpdatedAt(LocalDateTime.now());
        var saved = jpaProduceRepository.save(entity);
        return ProduceMapper.toDomain(saved);
    }

    @Override
    public List<Produce> findAll() {
        var entityList = jpaProduceRepository.findAll();
        return entityList.stream().map(ProduceMapper::toDomain)
                .toList();

    }

    @Override
    public Optional<Produce> findById(UUID produceId) {
        return jpaProduceRepository.findByProduceId(produceId)
                .map(ProduceMapper::toDomain);
    }

    @Override
    public void deleteById(UUID produceId) {
        jpaProduceRepository.deleteByProduceId(produceId);
    }
}
