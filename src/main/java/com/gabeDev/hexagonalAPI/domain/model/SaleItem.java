package com.gabeDev.hexagonalAPI.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class SaleItem {

    private  UUID produceId;
    private  String name;
    private  BigDecimal price;
    private  int quantity;

    public SaleItem(){

    }

    public SaleItem(UUID produceId, String name, BigDecimal price, int quantity){
        this.produceId = produceId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public UUID getProduceId(){
        return produceId;
    }
    public String getName(){
        return name;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setProduceId(UUID produceId){
        this.produceId = produceId;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
