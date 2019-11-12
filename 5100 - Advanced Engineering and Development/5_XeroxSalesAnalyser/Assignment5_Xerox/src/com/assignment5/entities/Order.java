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
public class Order {
    
    int orderId;
    int salesId;

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
    int customerId;
    Item item;
    String market;

    public Order(int orderId, int salesId, int customerId, Item item,String market) {
        this.orderId = orderId;
        this.salesId = salesId;
        this.customerId = customerId;
        this.item = item;
        this.market = market;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", salesId=" + salesId + ", customerId=" + customerId + ", market=" + market + ", item=" + item + '}';
    }
    
}
