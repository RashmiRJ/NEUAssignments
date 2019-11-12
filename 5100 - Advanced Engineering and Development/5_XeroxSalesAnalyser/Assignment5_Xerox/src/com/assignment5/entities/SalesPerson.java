/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

/**
 *
 * @author kasai
 */
public class SalesPerson {
     private int salesId;
    private int orderId;
    private int productId;
    private int quantity;
    private int salesPrice;
    
    public SalesPerson(int salesId, int orderId, int productId, int quantity, int salesPrice) {
        this.salesId = salesId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.salesPrice = salesPrice;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return "SalesPerson{" + "salesId=" + salesId + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", salesPrice=" + salesPrice + '}';
    }
}
