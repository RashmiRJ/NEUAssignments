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
public class Product {
  private  int productId;
  private float maxprice;
  private float minprice;
    private int targetPrice;
  
   public Product(int productId, int minPrice, int maxPrice, int targetPrice) {
        this.productId = productId;
        this.minprice = minPrice;
        this.maxprice = maxPrice;
        this.targetPrice = targetPrice;
    }

    public int getProductid() {
        return productId;
    }

    public void setProductid(int productid) {
        this.productId = productid;
    }

    public float getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(float maxprice) {
        this.maxprice = maxprice;
    }

    public float getMinprice() {
        return minprice;
    }

    public void setMinprice(float minprice) {
        this.minprice = minprice;
    }
    
    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", minPrice=" + minprice + ", maxPrice=" + maxprice + ", targetPrice=" + targetPrice + '}';
    }
}
