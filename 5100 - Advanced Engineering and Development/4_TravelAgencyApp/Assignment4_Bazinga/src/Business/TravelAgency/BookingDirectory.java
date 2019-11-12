/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

import Business.Customer.Passenger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author shriya22
 */
public class BookingDirectory {
    private ArrayList<Booking> bookingList;
    int bookingcounter = 2;
     public BookingDirectory(){
        bookingList = new ArrayList<Booking>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
         Date chosenDate = null;
        Booking b1 = new Booking();
          try {
            chosenDate = sf.parse("2019-11-11");
          }catch (ParseException e) {
        }
           ArrayList<Passenger> customerList;
            customerList = new ArrayList<Passenger>();
              Passenger p1 = new Passenger();
        p1.addPassenger("Sally", 40, "1C");
        
        customerList.add(p1);
        
      
          
        b1.addDummy(1, "BOS", "NYC", chosenDate, "Noon", 1, 2, "Qatar", 1000.00, 1000.00,customerList );
        bookingList.add(b1);
     }
    

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Booking addBooking() {
        Booking newBook = new Booking();
        newBook.setBookingReference(bookingcounter++);
        bookingList.add(newBook);
        return newBook;
    }
    
    public Booking searchBooking(int bookingref){
         for(Booking booking : bookingList){
             if(booking.getBookingReference() == bookingref){
                 return booking;
             }
         }
        return null;
        
    }
    
    
}
