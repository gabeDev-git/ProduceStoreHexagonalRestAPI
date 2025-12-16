package com.gabeDev.hexagonalAPI.adapter.persistence.mapper;

import com.gabeDev.hexagonalAPI.adapter.persistence.entity.SaleEntity;
import com.gabeDev.hexagonalAPI.adapter.persistence.entity.SaleItemEntity;
import com.gabeDev.hexagonalAPI.domain.model.Sale;
import com.gabeDev.hexagonalAPI.domain.model.SaleItem;

import java.util.ArrayList;
import java.util.List;


public class SaleMapper {

    public static SaleEntity toEntity(Sale sale){
        SaleEntity entity = new SaleEntity();
        entity.setSaleId(sale.getSaleId());
        entity.setPaymentMethod(sale.getPaymentMethod());
        entity.setTotal(sale.getTotal());

        for(SaleItem item : sale.getCheckout()){
            SaleItemEntity itemEntity = new SaleItemEntity();
            itemEntity.setProduceId(item.getProduceId());
            itemEntity.setName(item.getName());
            itemEntity.setPrice(item.getPrice());
            itemEntity.setQuantity(item.getQuantity());
            itemEntity.setSale(entity);

            entity.getCheckout().add(itemEntity);
        }

        return entity;
    }

    public static Sale toDomain(SaleEntity entity){
        List<SaleItem> itemList = new ArrayList<>();

        for(SaleItemEntity itemEntity : entity.getCheckout()){
            SaleItem saleItem = new SaleItem();
            saleItem.setProduceId(itemEntity.getProduceId());
            saleItem.setName(itemEntity.getName());
            saleItem.setPrice(itemEntity.getPrice());
            saleItem.setQuantity(itemEntity.getQuantity());

            itemList.add(saleItem);
        }

        return new Sale(entity.getSaleId(), itemList, entity.getTotal(),
                entity.getPaymentMethod());
    }

}
