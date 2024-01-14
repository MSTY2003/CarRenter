package entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Car {

    private int carID;
    private String carName;
    private String carPrice;
    private String carType;
    private String carDis;
    private int carMaster;
    private String carState;
    private Integer renter;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarDis() {
        return carDis;
    }

    public void setCarDis(String carDis) {
        this.carDis = carDis;
    }

    public int getCarMaster() {
        return carMaster;
    }

    public void setCarMaster(int carMaster) {
        this.carMaster = carMaster;
    }

    public String getCarState() {
        return carState;
    }

    public void setCarState(String carState) {
        this.carState = carState;
    }

    public int getRenter() {
        return renter;
    }

    public void setRenter(int renter) {
        this.renter = renter;
    }
// ... getters and setters

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 将Car对象转换为JSON字符串
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
