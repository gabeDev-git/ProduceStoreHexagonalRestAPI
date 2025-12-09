package com.gabeDev.hexagonalAPI.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Sale {

    private UUID saleId;
    private List<Produce> checkout;
    private BigDecimal total;
    private PaymentMethod paymentMethod;

    public Sale(){

    }
    public Sale(UUID saleId, List<Produce> checkout, BigDecimal total, PaymentMethod paymentMethod){
        this.saleId = saleId;
        this.checkout = checkout;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    private BigDecimal calculateTotal(List<Produce> checkout){
        BigDecimal total = BigDecimal.ZERO;
        for(Produce produce : checkout){
            total = total.add(produce.getPrice());
        }
        return total;
    }

    public UUID getSaleId(){
        return saleId;
    }
    public List<Produce> getCheckout(){
        return checkout;
    }
    public BigDecimal getTotal(){
        return total;
    }
    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    public void setSaleId(UUID id){
        this.saleId = id;
    }
    public void setCheckout(List<Produce> checkout){
        this.checkout = checkout;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
}
