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
public class AirlinerDirectory {
    private ArrayList<Airliner> airlinerList;
    
    public AirlinerDirectory(){
        airlinerList = new ArrayList<Airliner>();
        
         Airplane alp1 = new Airplane();
        Airplane alp2 = new Airplane();
        Airplane alp3 = new Airplane();
        Airplane alp4 = new Airplane();
        
        Airliner alr1 = new Airliner();
        Airliner alr2 = new Airliner();
        Airliner alr3 = new Airliner();
        Airliner alr4 = new Airliner();
        Airliner alr5 = new Airliner();
        
        ArrayList<Airplane> alpList = new ArrayList<>();
        alp1.alpLoadData(1, "Boeing777", 100);
        alpList.add(alp1);
        alp2.alpLoadData(2, "Boeing777", 150);
        alpList.add(alp2);
        alp3.alpLoadData(3, "Boeing777", 200);
        alpList.add(alp3);
        alp4.alpLoadData(4, "Boeing777", 180);
        alpList.add(alp4);
        
        alr1.alrLoadData("Qatar", "Street 1", "Doha", "Qatar", "Qatar", "1235", alpList);
        alr2.alrLoadData("Emirates", "Street 2", "Abu Dhabi", "Dubai", "UAE", "1244", alpList);
        alr3.alrLoadData("British Airways", "No. 35", "London", "London", "England", "40551", alpList);
        alr4.alrLoadData("El Al", "25", "Tel Aviv", "Israel", "Israel", "50001", alpList);
        alr5.alrLoadData("Air India", "No. 37", "New Delhi", "New Delhi", "India", "10001", alpList);
        
        
        airlinerList.add(alr1);
        airlinerList.add(alr2);
        airlinerList.add(alr3);
        airlinerList.add(alr4);
        airlinerList.add(alr5);
                
        
    }

    public ArrayList<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(ArrayList<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }
    public Airliner addAirliner(){
        Airliner newAirliner = new Airliner();
        airlinerList.add(newAirliner);
        return newAirliner;
    }
}
