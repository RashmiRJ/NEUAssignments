/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Customer.Passenger;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author shriya22
 */
public class Booking {
    private int bookingReference;
    private String source;
    private String destination;
    private Date startDate;
    private String FlyingTime;
    private int passengerNumber;
    private int flightNumber;
    private String flightName;
    private Double seatCost;
    private Double Totalcost;
    private ArrayList<Passenger> passengerList;
    
    public void addDummy(int bookingReference ,String source ,String destination ,Date startDate ,String FlyingTime ,int passengerNumber ,int flightNumber ,String flightName ,Double seatCost, Double Totalcost,ArrayList<Passenger> passengerList ) {
        this.bookingReference = bookingReference;
        this.source = source;
        this.destination = destination;
        this.startDate = startDate;
        this.FlyingTime = FlyingTime;
        this.passengerNumber = passengerNumber;
        this.flightNumber = flightNumber;
        this.flightName = flightName;
        this.seatCost = seatCost;
        this.Totalcost = Totalcost;
        this.passengerList = passengerList;
    }

    public Double getSeatCost() {
        return seatCost;
    }

    public void setSeatCost(Double seatCost) {
        this.seatCost = seatCost;
    }

    public Double getTotalcost() {
        return Totalcost;
    }

    public String getFlyingTime() {
        return FlyingTime;
    }

    public void setFlyingTime(String FlyingTime) {
        this.FlyingTime = FlyingTime;
    }

    public void setTotalcost(Double cost ,int passengerNumber ) {
        this.Totalcost = cost * passengerNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    

    public int getBookingReference() {
        return bookingReference;
    }
    
    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void setBookingReference(int bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.getBookingReference()); //To change body of generated methods, choose Tools | Templates.
    }
    
}
