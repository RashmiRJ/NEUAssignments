/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Flights;

import Business.TravelAgency.SeatDirectory;
import java.util.Date;

/**
 *
 * @author rashmirj
 */
public class Flight {
    private int flNumber; 
    private String flFromLoc;
    private String flToLoc;
    private String flFlyingTime;
    private double flCost;
    private String flAirlinerName;
    private Date flDate;
   private int fltCapacity;
    private int alpNumber;
    private SeatDirectory flSeatDir;
    
    public void flLoadData(int flNumber,String flFromLoc, String flToLoc, String flFlyingTime,double flCost,String flAirlinerName,Date flDate,int alpNumber, SeatDirectory sdr ){
        this.flNumber = flNumber;
        this.flFromLoc = flFromLoc;
        this.flToLoc = flToLoc;
        this.flFlyingTime= flFlyingTime;
        this.flCost = flCost;
        this.flAirlinerName = flAirlinerName;
        this.flDate = flDate;
        this.fltCapacity = 150;
        this.alpNumber = alpNumber;
        this.flSeatDir = sdr;
    }

    public SeatDirectory getFlSeatDir() {
        return flSeatDir;
    }

    public void setFlSeatDir(SeatDirectory flSeatDir) {
        this.flSeatDir = flSeatDir;
    }

    public int getAlpNumber() {
        return alpNumber;
    }

    public void setAlpNumber(int alpNumber) {
        this.alpNumber = alpNumber;
    }

    public Date getFlDate() {
        return flDate;
    }

    public int getFltCapacity() {
        return fltCapacity;
    }

    public void setFltCapacity(int fltCapacity) {
        this.fltCapacity = fltCapacity;
    }

    public void setFlDate(Date flDate) {
        this.flDate = flDate;
    }

    public String getFlAirlinerName() {
        return flAirlinerName;
    }

    public void setFlAirlinerName(String flAirlinerName) {
        this.flAirlinerName = flAirlinerName;
    }
    
    public int getFlNumber() {
        return flNumber;
    }

    public void setFlNumber(int flNumber) {
        this.flNumber = flNumber;
    }

    public String getFlFromLoc() {
        return flFromLoc;
    }

    public void setFlFromLoc(String flFromLoc) {
        this.flFromLoc = flFromLoc;
    }

    public String getFlToLoc() {
        return flToLoc;
    }

    public void setFlToLoc(String flToLoc) {
        this.flToLoc = flToLoc;
    }

    public String getFlFlyingTime() {
        return flFlyingTime;
    }

    public void setFlFlyingTime(String flFlyingTime) {
        this.flFlyingTime = flFlyingTime;
    }

    public double getFlCost() {
        return flCost;
    }

    public void setFlCost(double flCost) {
        this.flCost = flCost;
    }
    
     @Override
    public String toString() {
        return this.getFlAirlinerName(); //To change body of generated methods, choose Tools | Templates.
    }      
}
