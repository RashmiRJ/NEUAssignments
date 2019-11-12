/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Airline;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rashmirj
 */
public class Airliner {
    private String alrName;
    private String alrAddress;
    private String alrCity;
    private String alrState;
    private String alrCountry;
    private String alrZipCode;
    private int alrAirplaneCount;
    private ArrayList<Airplane> alrPlanes; //fleet
    
     public void alrLoadData(String alrName, String alrAddress, String alrCity, String alrState,String alrCountry, String alrZipCode,ArrayList<Airplane> alrPlanes) {
         this.alrAddress = alrAddress;
         this.alrCity = alrCity;
         this.alrCountry = alrCountry;
         this.alrName = alrName;
         this.alrPlanes = alrPlanes;
         this.alrState = alrState;
         this.alrZipCode = alrZipCode;
     }

    public int getAlrAirplaneCount() {
        this.alrAirplaneCount = alrPlanes.size();
        return alrAirplaneCount;
    }  

    public ArrayList<Airplane> getAlrPlanes() {
        return alrPlanes;
    }

    public void setAlrPlanes(ArrayList<Airplane> alrPlanes) {
        this.alrPlanes = alrPlanes;
    }   

    public String getAlrName() {
        return alrName;
    }

    public void setAlrName(String alrName) {
        this.alrName = alrName;
    }

    public String getAlrAddress() {
        return alrAddress;
    }

    public void setAlrAddress(String alrAddress) {
        this.alrAddress = alrAddress;
    }

    public String getAlrCity() {
        return alrCity;
    }

    public void setAlrCity(String alrCity) {
        this.alrCity = alrCity;
    }

    public String getAlrState() {
        return alrState;
    }

    public void setAlrState(String alrState) {
        this.alrState = alrState;
    }

    public String getAlrCountry() {
        return alrCountry;
    }

    public void setAlrCountry(String alrCountry) {
        this.alrCountry = alrCountry;
    }

    public String getAlrZipCode() {
        return alrZipCode;
    }

    public void setAlrZipCode(String alrZipCode) {
        this.alrZipCode = alrZipCode;
    }
   @Override
    public String toString() {
        return this.getAlrName(); //To change body of generated methods, choose Tools | Templates.
    }         
    
}
