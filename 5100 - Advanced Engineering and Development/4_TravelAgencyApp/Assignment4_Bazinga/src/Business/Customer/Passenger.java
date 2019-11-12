/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author shriya22
 */
public class Passenger {
    private String name;
    private int age;
    private String seat;    
  /*  private ArrayList<Seat> seatList;

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;}
        */
    public void addPassenger(String name, int age, String seat) {
        this.age = age;
        this.name = name;
        this.seat = seat;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
     @Override
    public String toString() {
        return this.getName(); //To change body of generated methods, choose Tools | Templates.
    }      
}
