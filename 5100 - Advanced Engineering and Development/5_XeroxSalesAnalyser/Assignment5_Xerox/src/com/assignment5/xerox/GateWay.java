/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analytics.AnalysisHelper;
import com.assignment5.analytics.DataStore;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kasai
 */
public class GateWay {

    DataReader orderreader;
    DataReader productReader;
    AnalysisHelper helper;
    List<Customer> customerlist = new ArrayList<Customer>();
    List<SalesPerson> salesPersonlist = new ArrayList<SalesPerson>();

    public GateWay() throws IOException {
        DataGenerator generator = DataGenerator.getInstance();
        orderreader = new DataReader(generator.getOrderFilePath());
        productReader = new DataReader(generator.getProductCataloguePath());
        helper = new AnalysisHelper();
    }

    public static void main(String args[]) throws IOException {
        GateWay inst = new GateWay();
        inst.readData();
    }

    private void readData() throws IOException {
        String[] row;
        while ((row = productReader.getNextRow()) != null) {
            generateProduct(row);
        }
        while ((row = orderreader.getNextRow()) != null) {
            Item item = generateItem(row);
            generateOrder(row, item);
            generateCustomer(row);
            generateSalesPerson(row);
        }
        runAnalysis();
    }

    private void generateProduct(String[] row) {
        int productID = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Product product = new Product(productID, minPrice, maxPrice, targetPrice);
        DataStore.getInstance().getProducts().put(productID, product);
    }

    private void generateOrder(String[] row, Item item) {
        int orderID = Integer.parseInt(row[0]);
        int salesID = Integer.parseInt(row[4]);
        int customerID = Integer.parseInt(row[5]);
        String segment = row[7];

        Order order = new Order(orderID, salesID, customerID, item, segment);
        DataStore.getInstance().getOrders().put(orderID, order);
    }

    private Item generateItem(String[] row) {
        int itemId = Integer.parseInt(row[1]);
        int productID = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        int price = Integer.parseInt(row[6]);

        Item item = new Item(productID, price, quantity, itemId);
        DataStore.getInstance().getItems().put(itemId, item);
        return item;
    }

    private void generateCustomer(String[] row) {
        int customerId = Integer.valueOf(row[5]);
        int orderId = Integer.valueOf(row[0]);
        int productId = Integer.valueOf(row[2]);
        int quantity = Integer.valueOf(row[3]);
        int salesPrice = Integer.valueOf(row[6]);

        Customer customer = new Customer(customerId, orderId, productId, quantity, salesPrice);
        this.customerlist.add(customer);        
    }

    private void generateSalesPerson(String[] row) {
        int salesId = Integer.valueOf(row[4]);
        int orderId = Integer.valueOf(row[0]);
        int productId = Integer.valueOf(row[2]);
        int quantity = Integer.valueOf(row[3]);
        int salesPrice = Integer.valueOf(row[6]);

        SalesPerson sales = new SalesPerson(salesId, orderId, productId, quantity, salesPrice);
        salesPersonlist.add(sales);
    }

    private void runAnalysis() {
        helper.threeBestNegotiatedProducts();
        helper.threeBestCustomers(customerlist);
        helper.threeBestSalesPeople(salesPersonlist);
        helper.totalRevenue();
        helper.printTableOriginal();
        helper.printTableModified();
    }
}
