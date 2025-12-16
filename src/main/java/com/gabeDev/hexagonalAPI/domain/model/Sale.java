package com.gabeDev.hexagonalAPI.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Sale {

    private UUID saleId;
    private List<SaleItem> checkout;
    private BigDecimal total;
    private PaymentMethod paymentMethod;

    public Sale(UUID saleId, List<SaleItem> checkout, BigDecimal total, PaymentMethod paymentMethod){
        this.saleId = saleId;
        this.checkout = checkout;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public Sale(List<SaleItem> checkout, BigDecimal total, PaymentMethod paymentMethod){
        this.checkout = checkout;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public static BigDecimal getTotal(List<SaleItem> checkout){
        BigDecimal total = BigDecimal.ZERO;
        for(SaleItem item : checkout){
            total = total.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return total;
    }

    public UUID getSaleId(){
        return saleId;
    }
    public List<SaleItem> getCheckout(){
        return checkout;
    }
    public BigDecimal getTotal(){
        return total;
    }
    public PaymentMethod getPaymentMethod(){
        return paymentMethod;
    }

    public void setCheckout(List<SaleItem> checkout){
        this.checkout = checkout;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public void setSaleId(UUID id){
        this.saleId = id;
    }
}
