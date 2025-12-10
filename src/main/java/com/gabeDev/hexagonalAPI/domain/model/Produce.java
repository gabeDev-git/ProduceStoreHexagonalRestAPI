package com.gabeDev.hexagonalAPI.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Produce {

    private UUID produceId;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Produce(){
        this.produceId = UUID.randomUUID();
    }

    public Produce(String name, BigDecimal price, int quantity){
        this.produceId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount){
        validateAmount(amount);
        this.quantity =+ amount;
    }
    public void decreaseQuantity(int amount){
        validateAmount(amount);
        validateQuantity(amount);
        this.quantity -= amount;
    }

    private void validateAmount(int amount){
        if(amount <= 0){
            throw new RuntimeException("Cannot increase or decrease by 0 or less");
        }
    }

    private void validateQuantity(int amount){
        if(this.quantity - amount < 0){
            throw new RuntimeException("Amount greater than current quantity");
        }
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

    public void setProduceId(UUID id){
        this.produceId = produceId;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(BigDecimal price){
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Price can't be lower than 0");
        }
        this.price = price;
    }
    public void setQuantity(int quantity){
        if(quantity < 0){
            throw new RuntimeException("Quantity can't be less than 0");
        }
        this.quantity = quantity;
    }
}
