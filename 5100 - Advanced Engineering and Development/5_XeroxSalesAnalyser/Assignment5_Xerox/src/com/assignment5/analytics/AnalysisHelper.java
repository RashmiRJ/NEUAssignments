/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Customer;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shriya22
 */
public class AnalysisHelper {
        Map<Integer, Product> productsCopy = DataStore.getInstance().getProducts();
    
    public void threeBestNegotiatedProducts() {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        Map<Integer, Integer> productMap = new HashMap<>();
        Map<Integer, Integer> printableProductMap = new HashMap<>();

       for(Product p: products.values()) {
           int qtyAboveTarget = 0;
           for(Order o: orders.values()) {
               if((o.getItem().getProductId() == p.getProductid()) && (o.getItem().getSalesPrice() > p.getTargetPrice())){
                   qtyAboveTarget += o.getItem().getQuantity();
               }
           }
           productMap.put(p.getProductid(),qtyAboveTarget);
       }
       
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(productMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });       
        
        int top3 = 3;
        for (int i = 0; i < list.size() && top3 > 0; i++) {
            if(printableProductMap.containsValue(list.get(i).getValue())) {
                printableProductMap.put(list.get(i).getKey(), list.get(i).getValue());
            }
            else {
                top3--;
                printableProductMap.put(list.get(i).getKey(), list.get(i).getValue());
            }
        }
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("Top 3 Best Negotiated Products:");
        for(int i=0; i<printableProductMap.size();i++) {            
            System.out.println(i+1 +") Product ID: " +list.get(i).getKey() +", Total Qty sold above target: "+list.get(i).getValue());
        }
        System.out.println("________________________________________________________________________________________________________________________");
    }
    public void threeBestCustomers(List<Customer> customerlist) {
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        List<Customer> customers = customerlist;
        Map<Integer, Integer> customerSalePriceMap = new HashMap<>();
        Map<Integer, Integer> customerTargetPriceMap = new HashMap<>();
        Map<Integer, Integer> customerMap = new HashMap<>();
        Map<Integer, Integer> printableCustomerMap = new HashMap<>();
        
        for(Customer c: customers){
            int targetPrice = 0;
            int cid = c.getCustomerId();
            int csp = c.getSalesPrice();
            int cqty = c.getQuantity();
            if(customerSalePriceMap.containsKey(cid)){
                customerSalePriceMap.put(cid,customerSalePriceMap.get(cid) + (csp*cqty));
                for(Product p:products.values()){                   
                    if(p.getProductid()== c.getProductId()){
                        targetPrice = p.getTargetPrice();
                    }                    
                }
            customerTargetPriceMap.put(cid, customerTargetPriceMap.get(cid) + (targetPrice*cqty));
            } else {
            customerSalePriceMap.put(cid, csp*cqty);
            for(Product p:products.values()){                   
                    if(p.getProductid()== c.getProductId()){
                        targetPrice = p.getTargetPrice();
                    }                    
                }
            customerTargetPriceMap.put(cid, targetPrice*cqty);
            }
        }
        
        for(int id : customerTargetPriceMap.keySet()){
            int difference = Math.abs(customerSalePriceMap.get(id) - customerTargetPriceMap.get(id));
            customerMap.put(id, difference);            
        }
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(customerMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });       
        
        int top3 = 3;
        for (int i = 0; i < list.size() && top3 > 0; i++) {
            if(printableCustomerMap.containsValue(list.get(i).getValue())) {
                printableCustomerMap.put(list.get(i).getKey(), list.get(i).getValue());
            }
            else {
                top3--;
                printableCustomerMap.put(list.get(i).getKey(), list.get(i).getValue());
            }
        }
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("Top 3 Best Customers:");
        for(int i=0; i<printableCustomerMap.size();i++) {            
            System.out.println(i+1 +") Customer ID: " +list.get(i).getKey() +", Total sales price above target: "+list.get(i).getValue());
        }
        System.out.println("________________________________________________________________________________________________________________________");
   
    
    }
     public void threeBestSalesPeople(List<SalesPerson> salesPersonlist) {
        //calculate total price
        Map<Integer, Integer> totalSalesPrice = new HashMap<>();
        Map<Integer, Integer> totalTargetPrice = new HashMap<>();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        Map<Integer, Integer> printableProductMap = new HashMap<>();
        List<SalesPerson> SPlist = salesPersonlist;
        Map<Integer, Integer> Profit = new HashMap<>();

        int SPsalesprice = 0;
        int SPtargetprice = 0;
        for (SalesPerson s : SPlist) {
            int targetPrice = 0;
            if (totalSalesPrice.containsKey(s.getSalesId())) {
                SPsalesprice = totalSalesPrice.get(s.getSalesId()) + (s.getSalesPrice() * s.getQuantity());

                for (Product p : products.values()) {
                    if (p.getProductid() == s.getProductId()) {
                        targetPrice = p.getTargetPrice();
                    }
                }
                SPtargetprice = totalTargetPrice.get(s.getSalesId()) + (targetPrice * s.getQuantity());

            } else {
                SPsalesprice = s.getSalesPrice() * s.getQuantity();

                for (Product p : products.values()) {
                    if (p.getProductid() == s.getProductId()) {
                        targetPrice = p.getTargetPrice();
                    }
                }
                SPtargetprice = targetPrice * s.getQuantity();
            }

            totalSalesPrice.put(s.getSalesId(), SPsalesprice);
            totalTargetPrice.put(s.getSalesId(), SPtargetprice);

        }
       
        for (int id : totalSalesPrice.keySet()) {
            int differenceSales = totalSalesPrice.get(id) - totalTargetPrice.get(id);
            Profit.put(id, differenceSales);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(Profit.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });
        
         int top3 = 3;
        for (int i = 0; i < list.size() && top3 > 0; i++) {
            if (printableProductMap.containsValue(list.get(i).getValue())) {
                printableProductMap.put(list.get(i).getKey(), list.get(i).getValue());
            } else {
                top3--;
                printableProductMap.put(list.get(i).getKey(), list.get(i).getValue());
            }
        }

        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("Top 3 Best Sales Person:");
        for (int i = 0; i < printableProductMap.size(); i++) {
            System.out.println(i + 1 + ") Sales ID: " + list.get(i).getKey() + ", Profit made: " + list.get(i).getValue());
        }
        System.out.println("________________________________________________________________________________________________________________________");
    
    }
     public void totalRevenue() {
         int totalRevenue =0;
         Map<Integer, Order> orders = DataStore.getInstance().getOrders();
         Map<Integer, Product> products = DataStore.getInstance().getProducts();
         //TotalRevenue += (Integer.valueOf( orderRow1[6])-minprice[Integer.valueOf(orderRow1[2])]) *Integer.valueOf(orderRow1[3]);
           for(Product p: products.values()) {
           for(Order o: orders.values()) {
               if((o.getItem().getProductId() == p.getProductid()) && (o.getItem().getSalesPrice() > p.getTargetPrice())){
                   totalRevenue += (o.getItem().getSalesPrice() - p.getTargetPrice()) * o.getItem().getQuantity();
               }
           }
       }
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println("Total revenue for the year:");
        System.out.println(totalRevenue);
        System.out.println("________________________________________________________________________________________________________________________");
    
         
    }
     
     
     public void printTableOriginal() {         
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
                
        Map<Integer, Integer> productHigherTP = new HashMap<>();
        Map<Integer, Integer> productLowerTP = new HashMap<>();
        Map<Integer, Integer> productHigherTPDiff = new HashMap<>();
        Map<Integer, Integer> productLowerTPDiff = new HashMap<>();
        
        for(Product p: products.values()){
            int totalSalePrice = 0;
            int totalQty = 0;
            for(Order o: orders.values()) {
                if(o.getItem().getProductId() == p.getProductid()) {
                    totalSalePrice += o.getItem().getSalesPrice() * o.getItem().getQuantity();
                    totalQty+=o.getItem().getQuantity();
                }
            }
            if((totalSalePrice/totalQty) > p.getTargetPrice()) {
            productHigherTP.put(p.getProductid(),(totalSalePrice/totalQty));
            productHigherTPDiff.put(p.getProductid(),(totalSalePrice/totalQty) - p.getTargetPrice());
            }
            else {
            productLowerTP.put(p.getProductid(),(totalSalePrice/totalQty));
            productLowerTPDiff.put(p.getProductid(),(totalSalePrice/totalQty) - p.getTargetPrice());
            }
        }    
        List<Map.Entry<Integer, Integer>> listHTP = new LinkedList<>(productHigherTPDiff.entrySet());
        Collections.sort(listHTP, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });
        
        List<Map.Entry<Integer, Integer>> listLTP = new LinkedList<>(productLowerTPDiff.entrySet());
        Collections.sort(listLTP, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });
        System.out.println("________________________________________________________________________________________________________________________");
         
        for (int i = 0; i < listLTP.size(); i++) {
           int pTP = products.get(listLTP.get(i).getKey()).getTargetPrice();
           int pid = listLTP.get(i).getKey();
           int avgSalesPrice = productLowerTP.get(listLTP.get(i).getKey());
           int diff = listLTP.get(i).getValue();
           System.out.println("Product ID: "+pid+" ;Avg Sales Pric: "+avgSalesPrice+" ;Target Price: "+pTP+" Difference: "+diff);
        }
        System.out.println("________________________________________________________________________________________________________________________");
           
        for (int i = 0; i < listHTP.size(); i++) {
           int pTP = products.get(listHTP.get(i).getKey()).getTargetPrice();
           int pid = listHTP.get(i).getKey();
           int avgSalesPrice = productHigherTP.get(listHTP.get(i).getKey());
           int diff = listHTP.get(i).getValue();
           System.out.println("Product ID: "+pid+" ;Avg Sales Pric: "+avgSalesPrice+" ;Target Price: "+pTP+" Difference: "+diff);
        }
     }
     
     public void printTableModified () {
        Map<Integer, Order> orders = DataStore.getInstance().getOrders();
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        Map<Integer, Float> error = new HashMap<>(); //use for printing error values
        Map<Integer, Integer> errorHigherTarget = new HashMap<>();
        Map<Integer, Integer> errorLowerTarget = new HashMap<>();
        Map<Integer, Integer> modifiedTarget = new HashMap<>(); // use for printing modified target
                
        Map<Integer, Integer> productHigherTP = new HashMap<>(); // use for printing avg
        Map<Integer, Integer> productLowerTP = new HashMap<>(); // use for printing avg
        Map<Integer, Integer> productHigherTPDiff = new HashMap<>(); // use for printing diff
        Map<Integer, Integer> productLowerTPDiff = new HashMap<>(); // use for printing diff
        Map<Integer, Integer> productNoChange = new HashMap<>(); // use for printing diff
        
        for(Product p: products.values()){
            int totalSalePrice = 0;
            int totalQty = 0;
            for(Order o: orders.values()) {
                if(o.getItem().getProductId() == p.getProductid()) {
                    totalSalePrice += o.getItem().getSalesPrice() * o.getItem().getQuantity();
                    totalQty+=o.getItem().getQuantity();
                }
            }
            float avgPrice = totalSalePrice/totalQty;
            if(p.getTargetPrice() < 0.95*avgPrice) {
                errorHigherTarget.put(p.getProductid(), (int)(0.95 * avgPrice));
                error.put(p.getProductid(),(((int)(0.95 * avgPrice))-avgPrice)/avgPrice);
                productHigherTP.put(p.getProductid(),(totalSalePrice/totalQty));
            productHigherTPDiff.put(p.getProductid(),(totalSalePrice/totalQty) - (int)(0.95 * avgPrice));
            } else if (p.getTargetPrice() > 1.05*avgPrice) {
                errorLowerTarget.put(p.getProductid(), (int)(1.05*avgPrice));
                error.put(p.getProductid(),(((int)(1.05 * avgPrice))-avgPrice)/avgPrice);
                productLowerTP.put(p.getProductid(),(totalSalePrice/totalQty));
                productLowerTPDiff.put(p.getProductid(),(totalSalePrice/totalQty) - (int)(1.05*avgPrice));
            } else {
                productNoChange.put(p.getProductid(), (totalSalePrice/totalQty));
                error.put(p.getProductid(),((p.getTargetPrice())-avgPrice)/avgPrice);
            }
        for(Map.Entry<Integer, Integer> mTarget: errorHigherTarget.entrySet()) {
            modifiedTarget.put(mTarget.getKey(), mTarget.getValue());
        }
        for(Map.Entry<Integer, Integer> mTarget: errorLowerTarget.entrySet()) {
            modifiedTarget.put(mTarget.getKey(), mTarget.getValue());
        }
        }
        List<Map.Entry<Integer, Integer>> listHTP = new LinkedList<>(productHigherTPDiff.entrySet());
        Collections.sort(listHTP, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });
        
        List<Map.Entry<Integer, Integer>> listLTP = new LinkedList<>(productLowerTPDiff.entrySet());
        Collections.sort(listLTP, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
                return (c2.getValue()).compareTo(c1.getValue());
            }
        });
        System.out.println("________________________________________________________________________________________________________________________");
        for (int i = 0; i < listLTP.size(); i++) {
           int pTP = modifiedTarget.get(listLTP.get(i).getKey());
           int pid = listLTP.get(i).getKey();
           int avgSalesPrice = productLowerTP.get(listLTP.get(i).getKey());
           int diff = listLTP.get(i).getValue();
           float err = error.get(listLTP.get(i).getKey());
           System.out.println("Product ID: "+pid+" ;Avg Sales Pric: "+avgSalesPrice+" ;Modified Target Price: "+pTP+" Difference: "+diff+" ;Error: "+err);
        }
        System.out.println("________________________________________________________________________________________________________________________");
           
        for (int i = 0; i < listHTP.size(); i++) {
           int pTP = modifiedTarget.get(listHTP.get(i).getKey());
           int pid = listHTP.get(i).getKey();
           int avgSalesPrice = productHigherTP.get(listHTP.get(i).getKey());
           int diff = listHTP.get(i).getValue();
           float err = error.get(listHTP.get(i).getKey());
           System.out.println("Product ID: "+pid+" ;Avg Sales Pric: "+avgSalesPrice+" ;Modified Target Price: "+pTP+" Difference: "+diff+" ;Error: "+err);
        }
        
        System.out.println("________________________________________________________________________________________________________________________");
           
        for (Map.Entry<Integer, Integer> i: productNoChange.entrySet()) {
           int pTP = i.getKey();
           int pid = i.getKey();
           int avgSalesPrice = i.getValue();
           float err = error.get(i.getKey());
           System.out.println("Product ID: "+pid+" ;Avg Sales Pric: "+avgSalesPrice+" ;Modified Target Price: N/A Difference: N/A ;Error: "+err);
        }
     }
    
    
}
