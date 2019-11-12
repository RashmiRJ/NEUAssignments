/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airline;

/**
 *
 * @author rashmirj
 */
public class Airplane {
    private int alnNumber;
    private String alnType;
    private int alnCapacity;

    public Airplane() {
    }

    public int getAlnNumber() {
        return alnNumber;
    }

    public void setAlnNumber(int alnNumber) {
        this.alnNumber = alnNumber;
    }

    public String getAlnType() {
        return alnType;
    }

    public void setAlnType(String alnType) {
        this.alnType = alnType;
    }

    public int getAlnCapacity() {
        return alnCapacity;
    }

    public void setAlnCapacity(int alnCapacity) {
        this.alnCapacity = alnCapacity;
    }
    
    public void alpLoadData(int num, String type, int capacity) {
        this.alnNumber = num;
        this.alnType = type;
        this.alnCapacity = capacity;
    }
    
   @Override
    public String toString() {
        return Integer.toString(this.getAlnNumber()); //To change body of generated methods, choose Tools | Templates.
    }
}
