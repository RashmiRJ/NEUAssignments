/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelAgency;

/**
 *
 * @author DivyaThanigaiArasu
 */
public class Seat {
    private String seatNum;
    private String seatType;
    private Boolean seatAvailable;

    public Boolean getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(Boolean seatAvailable) {
        this.seatAvailable = seatAvailable;
    }
    
    public void sLoadData (String seatNum, String seatType, Boolean available) {
        this.seatNum = seatNum;
        this.seatType = seatType;
        this.seatAvailable = available;
    }   

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
    @Override
    public String toString() {
        return this.getSeatNum();
    }

}
