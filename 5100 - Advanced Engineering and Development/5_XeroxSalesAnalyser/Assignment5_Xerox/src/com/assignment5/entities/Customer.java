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
public class Customer {
       private int customerId;
    private int orderId;
    private int productId;
    private int quantity;
    private int salesPrice;

    public Customer(int customerId, int orderId, int productId, int quantity, int salesPrice) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.salesPrice = salesPrice;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
    
    //usEdit
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", salesPrice=" + salesPrice + '}';
    }
    
}
