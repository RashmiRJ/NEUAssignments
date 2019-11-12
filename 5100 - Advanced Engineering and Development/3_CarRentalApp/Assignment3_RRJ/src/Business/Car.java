/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 * Date: Oct 5 2019
 * @author rashmirj
 * 
 * Object defining car and its attributes
 */
public class Car {

    private boolean available; //
    private boolean maintenanceCert; //
    private String city; //
    private String brand; //
    private int serialNum; //
    private int manufacturedYear; //
    private int minSeats; //
    private int maxSeats; //
    private String modelNum; //
    private Date lastUpdatedDate;

    public void CarManualAdd(boolean available, String brand, int manufacturedYear, int minSeats, int maxSeats, int serialNum, String modelNum, String city, boolean maintenanceCertificate) {
        this.available = available;
        this.brand = brand;
        this.manufacturedYear = manufacturedYear;
        this.minSeats = minSeats;
        this.maxSeats = maxSeats;
        this.serialNum = serialNum;
        this.modelNum = modelNum;
        this.city = city;
        this.maintenanceCert = maintenanceCertificate;
        this.lastUpdatedDate = new Date();
    }

    public Car() {
        this.lastUpdatedDate = new Date();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isMaintenanceCert() {
        return maintenanceCert;
    }

    public void setMaintenanceCert(boolean maintenanceCert) {
        this.maintenanceCert = maintenanceCert;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public int getMinSeats() {
        return minSeats;
    }

    public void setMinSeats(int minSeats) {
        this.minSeats = minSeats;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate() {
        this.lastUpdatedDate = new Date();
    }

    @Override
    public String toString() {
        return this.getCity(); //To change body of generated methods, choose Tools | Templates.
    }

}
