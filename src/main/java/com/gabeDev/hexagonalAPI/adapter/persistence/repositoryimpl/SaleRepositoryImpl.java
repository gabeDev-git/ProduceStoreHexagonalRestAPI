package com.gabeDev.hexagonalAPI.adapter.persistence.repositoryimpl;

import com.gabeDev.hexagonalAPI.adapter.persistence.entity.SaleEntity;
import com.gabeDev.hexagonalAPI.adapter.persistence.jparepository.JpaSaleRepository;
import com.gabeDev.hexagonalAPI.adapter.persistence.mapper.SaleMapper;
import com.gabeDev.hexagonalAPI.domain.model.Sale;
import com.gabeDev.hexagonalAPI.domain.port.out.SaleRepositoryPort;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SaleRepositoryImpl implements SaleRepositoryPort {

    private final JpaSaleRepository jpaSaleRepository;

    public SaleRepositoryImpl(JpaSaleRepository jpaSaleRepository){
        this.jpaSaleRepository = jpaSaleRepository;
    }

    @Override
    public Sale save(Sale sale) {
        SaleEntity entity = SaleMapper.toEntity(sale);
        SaleEntity saved = jpaSaleRepository.save(entity);
        return SaleMapper.toDomain(saved);
    }

    @Override
    public List<Sale> findAll() {
        return jpaSaleRepository.findAll().stream()
                .map(SaleMapper::toDomain).toList();
    }

    @Override
    public List<Sale> findAllSince(Instant instant) {
        return jpaSaleRepository.findByCreatedAtAfter(instant)
                .stream()
                .map(SaleMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Sale> findById(UUID id) {
        return jpaSaleRepository.findBySaleId(id)
                .map(SaleMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaSaleRepository.deleteBySaleId(id);
    }
}
