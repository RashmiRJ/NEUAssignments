/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Flights;

import Business.TravelAgency.Seat;
import Business.TravelAgency.SeatDirectory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rashmirj
 */
public class FlightDirectory {

    private ArrayList<Flight> flightList;

    public FlightDirectory() {
        flightList = new ArrayList<Flight>();

        Date chosenDate = null;
        Date chosenDate1 = null;
        Date chosenDate2 = null;
        Date chosenDate3 = null;
        Date chosenDate4 = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            chosenDate = sf.parse("2019-11-11");
            chosenDate1 = sf.parse("2019-11-12");
            chosenDate2 = sf.parse("2019-12-12");
            chosenDate3 = sf.parse("2019-12-01");
            chosenDate4 = sf.parse("2019-12-03");
        } catch (ParseException e) {
        }

        Flight f1 = new Flight();
        Flight f11 = new Flight();
        Flight f12 = new Flight();
        Flight f13 = new Flight();
        Flight f14 = new Flight();
        Flight f15 = new Flight();
        Flight f16 = new Flight();
        f1.flLoadData(1, "BOS", "BLR", "Morning", 1000.00, "Qatar", chosenDate, 1, new SeatDirectory());
        f11.flLoadData(2, "BOS", "NYC", "Noon", 1000.00, "Qatar", chosenDate1, 1, getDummyBooking());
        f12.flLoadData(3, "BOS", "BLR", "Evening", 1000.00, "Qatar", chosenDate2, 1, new SeatDirectory());
        f13.flLoadData(4, "BOS", "NYC", "Night", 1000.00, "Emirates", chosenDate3, 1, new SeatDirectory());
        f14.flLoadData(5, "BOS", "NYC", "Morning", 1000.00, "Emirates", chosenDate4, 1, new SeatDirectory());
        f15.flLoadData(6, "BOS", "BLR", "Noon", 1000.00, "Emirates", chosenDate, 1, new SeatDirectory());
        f16.flLoadData(7, "BOS", "BLR", "Noon", 1000.00, "Qatar", chosenDate, 1, new SeatDirectory());
        flightList.add(f1);
        flightList.add(f11);
        flightList.add(f12);
        flightList.add(f13);
        flightList.add(f14);
        flightList.add(f15);
        flightList.add(f16);
    }
    
    public SeatDirectory getDummyBooking() {
        ArrayList<Seat> seatDir = new ArrayList<Seat>();
        
        Seat s1 = new Seat();
        Seat s2 = new Seat();
        Seat s3 = new Seat();
        Seat s4 = new Seat();
        Seat s5 = new Seat();
        Seat s6 = new Seat();
        Seat s8 = new Seat();
        Seat s9 = new Seat();
        Seat s10 = new Seat();
        Seat s11 = new Seat();
        Seat s12 = new Seat();
        Seat s13 = new Seat();
        Seat s15 = new Seat();
        Seat s16 = new Seat();
        Seat s17 = new Seat();
        Seat s18 = new Seat();
        Seat s19 = new Seat();
        Seat s20 = new Seat();
        Seat s21 = new Seat();
        Seat s22 = new Seat();
        Seat s23 = new Seat();
        Seat s24 = new Seat();
        Seat s25 = new Seat();
        Seat s26 = new Seat();
        Seat s27 = new Seat();
        Seat s28 = new Seat();
        Seat s29 = new Seat();
        Seat s30 = new Seat();
        Seat s31 = new Seat();
        Seat s32 = new Seat();
        Seat s33 = new Seat();
        Seat s34 = new Seat();
        Seat s35 = new Seat();
        Seat s36 = new Seat();
        Seat s37 = new Seat();
        Seat s38 = new Seat();
        Seat s39 = new Seat();
        Seat s40 = new Seat();
        Seat s41 = new Seat();
        Seat s42 = new Seat();
        Seat s43 = new Seat();
        Seat s44 = new Seat();
        Seat s45 = new Seat();
        Seat s46 = new Seat();
        Seat s47 = new Seat();
        Seat s48 = new Seat();
        Seat s49 = new Seat();
        Seat s50 = new Seat();
        Seat s51 = new Seat();
        Seat s52 = new Seat();
        Seat s53 = new Seat();
        Seat s54 = new Seat();
        Seat s55 = new Seat();
        Seat s56 = new Seat();
        Seat s57 = new Seat();
        Seat s58 = new Seat();
        Seat s59 = new Seat();
        Seat s60 = new Seat();
        Seat s61 = new Seat();
        Seat s62 = new Seat();
        Seat s63 = new Seat();
        Seat s64 = new Seat();
        Seat s65 = new Seat();
        Seat s66 = new Seat();
        Seat s67 = new Seat();
        Seat s68 = new Seat();
        Seat s69 = new Seat();
        Seat s70 = new Seat();
        Seat s71 = new Seat();
        Seat s72 = new Seat();
        Seat s73 = new Seat();
        Seat s74 = new Seat();
        Seat s75 = new Seat();
        Seat s76 = new Seat();
        Seat s77 = new Seat();
        Seat s78 = new Seat();
        Seat s79 = new Seat();
        Seat s80 = new Seat();
        Seat s81 = new Seat();
        Seat s82 = new Seat();
        Seat s83 = new Seat();
        Seat s84 = new Seat();
        Seat s85 = new Seat();
        Seat s86 = new Seat();
        Seat s87 = new Seat();
        Seat s88 = new Seat();
        Seat s89 = new Seat();
        Seat s90 = new Seat();
        Seat s91 = new Seat();
        Seat s92 = new Seat();
        Seat s93 = new Seat();
        Seat s94 = new Seat();
        Seat s95 = new Seat();
        Seat s96 = new Seat();
        Seat s97 = new Seat();
        Seat s98 = new Seat();
        Seat s99 = new Seat();
        Seat s100 = new Seat();
        Seat s101 = new Seat();
        Seat s102 = new Seat();
        Seat s103 = new Seat();
        Seat s104 = new Seat();
        Seat s105 = new Seat();
        Seat s106 = new Seat();
        Seat s107 = new Seat();
        Seat s108 = new Seat();
        Seat s109 = new Seat();
        Seat s110 = new Seat();
        Seat s111 = new Seat();
        Seat s112 = new Seat();
        Seat s113 = new Seat();
        Seat s114 = new Seat();
        Seat s115 = new Seat();
        Seat s116 = new Seat();
        Seat s117 = new Seat();
        Seat s118 = new Seat();
        Seat s119 = new Seat();
        Seat s120 = new Seat();
        Seat s121 = new Seat();
        Seat s122 = new Seat();
        Seat s123 = new Seat();
        Seat s124 = new Seat();
        Seat s125 = new Seat();
        Seat s126 = new Seat();
        Seat s127 = new Seat();
        Seat s128 = new Seat();
        Seat s129 = new Seat();
        Seat s130 = new Seat();
        Seat s131 = new Seat();
        Seat s132 = new Seat();
        Seat s133 = new Seat();
        Seat s134 = new Seat();
        Seat s135 = new Seat();
        Seat s136 = new Seat();
        Seat s137 = new Seat();
        Seat s138 = new Seat();
        Seat s139 = new Seat();
        Seat s140 = new Seat();
        Seat s141 = new Seat();
        Seat s142 = new Seat();
        Seat s143 = new Seat();
        Seat s144 = new Seat();
        Seat s145 = new Seat();
               
        s1.sLoadData("1A","Window",false);
        s2.sLoadData("1B", "Middle",false);
        s3.sLoadData("1C", "Aisle",true);
        s4.sLoadData("1D", "Aisle",false);
        s5.sLoadData("1E", "Middle",false);
        s6.sLoadData("1F", "Window",false);
        s8.sLoadData("2A","Window",false);
        s9.sLoadData("2B", "Middle",false);
        s10.sLoadData("2C", "Aisle",false);
        s11.sLoadData("2D", "Aisle",false);
        s12.sLoadData("2E", "Middle",false);
        s13.sLoadData("2F", "Window",false);
        s15.sLoadData("3A","Window",false);
        s16.sLoadData("3B", "Middle",false);
        s17.sLoadData("3C", "Aisle",false);
        s18.sLoadData("3D", "Aisle",false);
        s19.sLoadData("3E", "Middle",false);
        s20.sLoadData("3F", "Window",false);
        s21.sLoadData("4A","Window",false);
        s22.sLoadData("4B", "Middle",false);
        s23.sLoadData("4C", "Aisle",false);
        s24.sLoadData("4D", "Aisle",false);
        s25.sLoadData("4E", "Middle",false);
        s26.sLoadData("4F", "Window",false);
        s27.sLoadData("5A","Window",false);
        s28.sLoadData("5B", "Middle",false);
        s29.sLoadData("5C", "Aisle",false);
        s30.sLoadData("5D", "Aisle",false);
        s31.sLoadData("5E", "Middle",false);
        s32.sLoadData("5F", "Window",false);
        s33.sLoadData("6A","Window",false);
        s34.sLoadData("6B", "Middle",false);
        s35.sLoadData("6C", "Aisle",false);
        s36.sLoadData("6D", "Aisle",false);
        s37.sLoadData("6E", "Middle",false);
        s38.sLoadData("6F", "Window",false);
        s39.sLoadData("7A","Window",false);
        s40.sLoadData("7B", "Middle",false);
        s41.sLoadData("7C", "Aisle",false);
        s42.sLoadData("7D", "Aisle",false);
        s43.sLoadData("7E", "Middle",false);
        s44.sLoadData("7F", "Window",false);
        s45.sLoadData("8A","Window",false);
        s46.sLoadData("8B", "Middle",false);
        s47.sLoadData("8C", "Aisle",false);
        s48.sLoadData("8D", "Aisle",false);
        s49.sLoadData("8E", "Middle",false);
        s50.sLoadData("8F", "Window",false);
        s50.sLoadData("9A","Window",false);
        s51.sLoadData("9B", "Middle",false);
        s52.sLoadData("9C", "Aisle",false);
        s53.sLoadData("9D", "Aisle",false);
        s54.sLoadData("9E", "Middle",false);
        s55.sLoadData("9F", "Window",false);
        s56.sLoadData("10A","Window",false);
        s57.sLoadData("10B", "Middle",false);
        s58.sLoadData("10C", "Aisle",false);
        s59.sLoadData("10D", "Aisle",false);
        s60.sLoadData("10E", "Middle",false);
        s61.sLoadData("10F", "Window",false);
        s62.sLoadData("11A","Window",false);
        s63.sLoadData("11B", "Middle",false);
        s64.sLoadData("11C", "Aisle",false);
        s65.sLoadData("11D", "Aisle",false);
        s66.sLoadData("11E", "Middle",false);
        s67.sLoadData("11F", "Window",false);
        s68.sLoadData("12A","Window",false);
        s69.sLoadData("12B", "Middle",false);
        s70.sLoadData("12C", "Aisle",false);
        s71.sLoadData("12D", "Aisle",false);
        s72.sLoadData("12E", "Middle",false);
        s73.sLoadData("12F", "Window",false);
        s74.sLoadData("13A","Window",false);
        s75.sLoadData("13B", "Middle",false);
        s76.sLoadData("13C", "Aisle",false);
        s77.sLoadData("13D", "Aisle",false);
        s78.sLoadData("13E", "Middle",false);
        s79.sLoadData("13F", "Window",false);
        s80.sLoadData("14A","Window",false);
        s81.sLoadData("14B", "Middle",false);
        s82.sLoadData("14C", "Aisle",false);
        s83.sLoadData("14D", "Aisle",false);
        s84.sLoadData("14E", "Middle",false);
        s85.sLoadData("14F", "Window",false);
        s86.sLoadData("15A","Window",false);
        s87.sLoadData("15B", "Middle",false);
        s88.sLoadData("15C", "Aisle",false);
        s89.sLoadData("15D", "Aisle",false);
        s90.sLoadData("15E", "Middle",false);
        s91.sLoadData("15F", "Window",false);
        s92.sLoadData("16A","Window",false);
        s93.sLoadData("16B", "Middle",false);
        s94.sLoadData("16C", "Aisle",false);
        s95.sLoadData("16D", "Aisle",false);
        s96.sLoadData("16E", "Middle",false);
        s97.sLoadData("16F", "Window",false);
        s98.sLoadData("17A","Window",false);
        s99.sLoadData("17B", "Middle",false);
        s100.sLoadData("17C", "Aisle",false);
        s101.sLoadData("17D", "Aisle",false);
        s102.sLoadData("17E", "Middle",false);
        s103.sLoadData("17F", "Window",false);
        s104.sLoadData("18A","Window",false);
        s105.sLoadData("18B", "Middle",false);
        s106.sLoadData("18C", "Aisle",false);
        s107.sLoadData("18D", "Aisle",false);
        s108.sLoadData("18E", "Middle",false);
        s109.sLoadData("18F", "Window",false);
        s110.sLoadData("19A","Window",false);
        s111.sLoadData("19B", "Middle",false);
        s112.sLoadData("19C", "Aisle",false);
        s113.sLoadData("19D", "Aisle",false);
        s114.sLoadData("19E", "Middle",false);
        s115.sLoadData("19F", "Window",false);
        s116.sLoadData("20A","Window",false);
        s117.sLoadData("20B", "Middle",false);
        s118.sLoadData("20C", "Aisle",false);
        s119.sLoadData("20D", "Aisle",false);
        s120.sLoadData("20E", "Middle",false);
        s121.sLoadData("20F", "Window",false);
        s122.sLoadData("21A","Window",false);
        s123.sLoadData("21B", "Middle",false);
        s124.sLoadData("21C", "Aisle",false);
        s125.sLoadData("21D", "Aisle",false);
        s126.sLoadData("21E", "Middle",false);
        s127.sLoadData("21F", "Window",false);
        s128.sLoadData("22A","Window",false);
        s129.sLoadData("22B", "Middle",false);
        s130.sLoadData("22C", "Aisle",false);
        s131.sLoadData("22D", "Aisle",false);
        s132.sLoadData("22E", "Middle",false);
        s133.sLoadData("22F", "Window",false);
        s134.sLoadData("23A","Window",false);
        s135.sLoadData("23B", "Middle",false);
        s136.sLoadData("23C", "Aisle",false);
        s137.sLoadData("23D", "Aisle",false);
        s138.sLoadData("23E", "Middle",false);
        s139.sLoadData("23F", "Window",false);
        s134.sLoadData("24A","Window",false);
        s135.sLoadData("24B", "Middle",false);
        s136.sLoadData("24C", "Aisle",false);
        s137.sLoadData("24D", "Aisle",false);
        s138.sLoadData("24E", "Middle",false);
        s139.sLoadData("24F", "Window",false);
        s140.sLoadData("25A","Window",false);
        s141.sLoadData("25B", "Middle",false);
        s142.sLoadData("25C", "Aisle",false);
        s143.sLoadData("25D", "Aisle",false);
        s144.sLoadData("25E", "Middle",false);
        s145.sLoadData("25F", "Window",false);
        
        seatDir.add(s1);
        seatDir.add(s2);
        seatDir.add(s3);
        seatDir.add(s4);
        seatDir.add(s5);
        seatDir.add(s6);
        seatDir.add(s8);
        seatDir.add(s9);
        seatDir.add(s10);
        seatDir.add(s11);
        seatDir.add(s12);
        seatDir.add(s13);
        seatDir.add(s15);
        seatDir.add(s16);
        seatDir.add(s17);
        seatDir.add(s18);
        seatDir.add(s19);
        seatDir.add(s20);
        seatDir.add(s21);
        seatDir.add(s22);
        seatDir.add(s23);
        seatDir.add(s24);
        seatDir.add(s25);
        seatDir.add(s26);
        seatDir.add(s27);
        seatDir.add(s28);
        seatDir.add(s30);
        seatDir.add(s31);
        seatDir.add(s32);
        seatDir.add(s33);
        seatDir.add(s34);
        seatDir.add(s35);
        seatDir.add(s36);
        seatDir.add(s37);
        seatDir.add(s38);
        seatDir.add(s39);
        seatDir.add(s40);
        seatDir.add(s41);
        seatDir.add(s42);
        seatDir.add(s43);
        seatDir.add(s44);
        seatDir.add(s45);
        seatDir.add(s46);
        seatDir.add(s47);
        seatDir.add(s48);
        seatDir.add(s49);
        seatDir.add(s50);
        seatDir.add(s51);
        seatDir.add(s52);
        seatDir.add(s53);
        seatDir.add(s54);
        seatDir.add(s55);
        seatDir.add(s56);
        seatDir.add(s57);
        seatDir.add(s58);
        seatDir.add(s59);
        seatDir.add(s60);
        seatDir.add(s61);
        seatDir.add(s62);
        seatDir.add(s63);
        seatDir.add(s64);
        seatDir.add(s65);
        seatDir.add(s66);
        seatDir.add(s67);
        seatDir.add(s68);
        seatDir.add(s69);
        seatDir.add(s70);
        seatDir.add(s71);
        seatDir.add(s72);
        seatDir.add(s73);
        seatDir.add(s74);
        seatDir.add(s75);
        seatDir.add(s76);
        seatDir.add(s77);
        seatDir.add(s78);
        seatDir.add(s79);
        seatDir.add(s80);
        seatDir.add(s81);
        seatDir.add(s82);
        seatDir.add(s83);
        seatDir.add(s84);
        seatDir.add(s85);
        seatDir.add(s86);
        seatDir.add(s87);
        seatDir.add(s88);
        seatDir.add(s89);
        seatDir.add(s90);
        seatDir.add(s91);
        seatDir.add(s92);
        seatDir.add(s93);
        seatDir.add(s94);
        seatDir.add(s95);
        seatDir.add(s96);
        seatDir.add(s97);
        seatDir.add(s98);
        seatDir.add(s99);
        seatDir.add(s100);
        seatDir.add(s101);
        seatDir.add(s102);
        seatDir.add(s103);
        seatDir.add(s104);
        seatDir.add(s105);
        seatDir.add(s106);
        seatDir.add(s107);
        seatDir.add(s108);
        seatDir.add(s109);
        seatDir.add(s110);
        seatDir.add(s111);
        seatDir.add(s112);
        seatDir.add(s113);
        seatDir.add(s114);
        seatDir.add(s115);
        seatDir.add(s116);
        seatDir.add(s117);
        seatDir.add(s118);
        seatDir.add(s119);
        seatDir.add(s120);
        seatDir.add(s121);
        seatDir.add(s122);
        seatDir.add(s123);
        seatDir.add(s124);
        seatDir.add(s125);
        seatDir.add(s126);
        seatDir.add(s127);
        seatDir.add(s128);
        seatDir.add(s129);
        seatDir.add(s130);
        seatDir.add(s131);
        seatDir.add(s132);
        seatDir.add(s133);
        seatDir.add(s134);
        seatDir.add(s135);
        seatDir.add(s136);
        seatDir.add(s137);
        seatDir.add(s138);
        seatDir.add(s139);
        seatDir.add(s140);
        seatDir.add(s141);
        seatDir.add(s142);
        seatDir.add(s143);
        seatDir.add(s144);
        seatDir.add(s145);
        SeatDirectory s = new SeatDirectory();
        s.setSeatDir(seatDir);
        return s;
        
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> searchFlight(String source, String destination, String startdate) {
        List<Flight> fl = new ArrayList<Flight>();

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        
        for(Flight flight : this.flightList){
            
         //shriya TODO : need to add flight capacity
            if(flight.getFlFromLoc().equalsIgnoreCase(source) && flight.getFlToLoc().equalsIgnoreCase(destination) && s.format(flight.getFlDate()).equalsIgnoreCase(startdate) ){//&& flight.getFltCapacity() > 0 ){
                fl.add(flight);
            }
        }
        return fl;
    }
    
    public List<Flight> searchFlight2(String airliner , String source, String destination, String startdate) {
        List<Flight> b = new ArrayList<Flight>();

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        
        for(Flight flight : this.flightList){

            if(flight.getFlAirlinerName().equalsIgnoreCase(airliner) && flight.getFlFromLoc().equalsIgnoreCase(source) && flight.getFlToLoc().equalsIgnoreCase(destination) && s.format(flight.getFlDate()).equalsIgnoreCase(startdate)  ){
                b.add(flight);
            }
        }
        return b;
    }

    public Flight addFlight() {
        Flight newFlt = new Flight();
        flightList.add(newFlt);
        return newFlt;
    }

}
