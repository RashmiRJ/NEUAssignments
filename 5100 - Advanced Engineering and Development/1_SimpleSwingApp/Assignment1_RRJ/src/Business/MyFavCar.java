package Business;

/**
 * Date    09-11-2019
 * @author rashmirj
 * 
 * Details
 * Defines the car object and its attributes. 
 * used in the Interface package to set values from one panel UI and retrieve values on another panel UI
 */
public class MyFavCar {
    
    private String name;                //name of the car 
    private String brand;               //brand/company of the car
    private String modelNum;            //the model number of the car
    private String cost;                //cost of the car
    private String color;               //color of the car
    private String serialNum;           //the serial number of the car
    private String dimensions;          //dimensions lengthXbreadth of the car
    private String gearType;            //automatic or manual gear setting of the car
    private String numOfSeats;          //number of seats in the car
    private String carType;             //cat type ex:hatch back, sedan etc
    private String yearManufactured;    //year of car manufacture
    private String hasABS;              //does the car have ABS? Yes or No
    private String grossWt;             //gross weight of the car
    private String mileage;             //mileage given 
    private String hasNavSystem;        //does it have an inbuilt navigation system? Yes or No
    private String imgPath;             //variable to store the car image's absolute path 
    
    //getters and setters for the variables-
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(String numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(String yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public String getHasABS() {
        return hasABS;
    }

    public void setHasABS(String hasABS) {
        this.hasABS = hasABS;
    }

    public String getGrossWt() {
        return grossWt;
    }

    public void setGrossWt(String grossWt) {
        this.grossWt = grossWt;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getHasNavSystem() {
        return hasNavSystem;
    }

    public void setHasNavSystem(String hasNavSystem) {
        this.hasNavSystem = hasNavSystem;
    }
   
    
}
