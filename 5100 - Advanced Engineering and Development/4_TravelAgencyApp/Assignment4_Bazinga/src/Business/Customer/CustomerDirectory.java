/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author rashmirj
 */
public class CustomerDirectory {
    private ArrayList<Passenger> customerList;
    
      public CustomerDirectory() {
        customerList = new ArrayList<Passenger>();
        
        Passenger p1 = new Passenger();
        Passenger p2 = new Passenger();
        Passenger p3 = new Passenger();
        Passenger p4 = new Passenger();
 
        
        p1.addPassenger("Jack", 25, "");
        p2.addPassenger("Jill", 28, ""); 
        p3.addPassenger("Harry", 32, "");
        p4.addPassenger("Jolly", 40, "");
        p4.addPassenger("Sally", 40, "");
        
        customerList.add(p1);
        customerList.add(p2);
        customerList.add(p3);
        customerList.add(p4);

         
        
      }

    public ArrayList<Passenger> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Passenger> customerList) {
        this.customerList = customerList;
    }  
    
    public Passenger addPassenger() {
        Passenger newP = new Passenger();
        customerList.add(newP);
        return newP;
    }
}
