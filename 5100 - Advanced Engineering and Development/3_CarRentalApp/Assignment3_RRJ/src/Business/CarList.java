/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date: Oct 5 2019
 * @author rashmirj
 * 
 * Object containing list of cars
 * used to do CRUD operations to the fleet of cars
 * also contains methods (along with their overloads) to filter data based on user input and return the right num of cars that match the criteria
 */
public class CarList {

    private static CarList carList;

    public static CarList getCarList() {
        return carList;
    }

    public static void setCarList(CarList carList) {
        CarList.carList = carList;
    }
    public List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getCarBrands() {
        List<String> uniqueBrands = new ArrayList<>();
        for (Car c : this.cars) {
            if (!(uniqueBrands.contains(c.getBrand()))) {
                uniqueBrands.add(c.getBrand());
            }
        }
        return uniqueBrands;
    }

    public List<String> getCarBrands(List<Car> temp) {
        List<String> uniqueBrands = new ArrayList<>();
        for (Car c : temp) {
            if (!(uniqueBrands.contains(c.getBrand()))) {
                uniqueBrands.add(c.getBrand());
            }
        }
        return uniqueBrands;
    }

    public List<Car> getFirstAvlCar() {
        List<Car> firstCar = new ArrayList<>();
        for (Car c : this.cars) {
            if (c.isAvailable()) {
                firstCar.add(c);
                break;
            }
        }
        return firstCar;
    }

    public List<Car> getFirstAvlCar(List<Car> temp) {
        List<Car> firstCar = new ArrayList<>();
        for (Car c : temp) {
            if (c.isAvailable()) {
                firstCar.add(c);
                break;
            }
        }
        return firstCar;
    }

    public void deleteCar(Car car) {
        cars.remove(car);
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car addCar() {
        Car newCar = new Car();
        cars.add(newCar);
        return newCar;
    }

    public CarList() {
        cars = new ArrayList<>();

        Car car1 = new Car();
        car1.CarManualAdd(true, "Ferrari", 2019, 1, 2, 1, "Red One", "Boston", true);
        Car car2 = new Car();
        car2.CarManualAdd(false, "BMW", 2019, 1, 4, 2, "X1", "New York", true);
        Car car3 = new Car();
        car3.CarManualAdd(true, "Toyota", 2018, 1, 4, 3, "T1", "Boston", true);
        Car car4 = new Car();
        car4.CarManualAdd(true, "GM", 2018, 1, 4, 4, "G1", "New York", true);
        Car car5 = new Car();
        car5.CarManualAdd(true, "Toyota", 2017, 1, 4, 5, "T2", "Chicago", true);
        Car car6 = new Car();
        car6.CarManualAdd(true, "GM", 2017, 1, 4, 6, "G2", "Chicago", false);
        Car car7 = new Car();
        car7.CarManualAdd(true, "Ferrari", 2016, 1, 4, 7, "G7", "Seattle", true);
        Car car8 = new Car();
        car8.CarManualAdd(true, "BMW", 2016, 1, 4, 8, "X2", "Seattle", true);
        Car car9 = new Car();
        car9.CarManualAdd(false, "Toyota", 2019, 1, 4, 9, "T3", "Austin", true);
        Car car10 = new Car();
        car10.CarManualAdd(true, "GM", 2019, 1, 4, 10, "G3", "Austin", true);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        cars.add(car9);
        cars.add(car10);
    }

    public int getAvlCars() {
        int avl = 0;
        for (Car c : this.cars) {
            if (c.isAvailable()) {
                avl = avl + 1;
            }
        }
        return avl;
    }

    public int getNotAvlCars() {
        int notAvl = 0;
        for (Car c : this.cars) {
            if (!(c.isAvailable())) {
                notAvl = notAvl + 1;
            }
        }
        return notAvl;
    }

    public Date getLastUpd() {
        Date lastDate, currDate;
        int last = cars.size();
        lastDate = cars.get(last - 1).getLastUpdatedDate();
        for (Car c : this.cars) {
            currDate = c.getLastUpdatedDate();
            if (currDate.after(lastDate)) {
                lastDate = currDate;
            }
        }
        return lastDate;
    }

    //
    public int getAvlCars(List<Car> temp) {
        int avl = 0;
        for (Car c : temp) {
            if (c.isAvailable()) {
                avl = avl + 1;
            }
        }
        return avl;
    }

    public int getNotAvlCars(List<Car> temp) {
        int notAvl = 0;
        for (Car c : temp) {
            if (!(c.isAvailable())) {
                notAvl = notAvl + 1;
            }
        }
        return notAvl;
    }

    public Date getLastUpd(List<Car> temp) {
        Date lastDate, currDate;
        int last = temp.size();
        lastDate = temp.get(last - 1).getLastUpdatedDate();
        for (Car c : temp) {
            currDate = c.getLastUpdatedDate();
            if (currDate.after(lastDate)) {
                lastDate = currDate;
            }
        }
        return lastDate;
    }

    public List<Car> filterCity(String city, List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (c.getCity().equalsIgnoreCase(city)) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Car> filterBrand(String brand, List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Car> filterSeats(int min, int max, List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (c.getMinSeats() >= min && c.getMaxSeats() <= max) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Car> filterYear(int year, List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (c.getManufacturedYear() == year) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Car> filterSerialNum(int sNum, List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (c.getSerialNum() == sNum) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Car> filterModelNum(String mNum, List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (c.getModelNum().equalsIgnoreCase(mNum)) {
                result.add(c);
            }
        }
        return result;
    }

    public List<Car> filterEXpMCert(List<Car> tempList) {
        List<Car> result = new ArrayList<>();
        for (Car c : tempList) {
            if (!(c.isMaintenanceCert())) {
                result.add(c);
            }
        }
        return result;
    }

}
