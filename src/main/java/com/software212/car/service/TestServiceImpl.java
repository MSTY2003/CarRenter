package com.software212.car.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.software212.car.dao.TestDao;
import entity.Car;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    public TestDao testDao;
    @Override
    public String getCarById(int carID){//根据id查询车辆
        String sql = "SELECT * FROM car WHERE carID = ?";
        Object[] param = new Object[]{carID};
        List<Car> cars = testDao.query(sql, param);
        if (!cars.isEmpty()) {
            return cars.get(0).toString();
        } else {
            return "No car found with ID: " + carID;
        }
    }


    @Override
    public String getCarInfo() {//查询所有车辆
        String sql = "SELECT * FROM car";
        List<Car> cars = testDao.query(sql, new Object[]{});
        List<String> carJsons = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(Car car : cars){
            try {
                carJsons.add(mapper.writeValueAsString(car));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return carJsons.toString();
    }

    @Override
    public String getUserInfo() { //查询所有用户
        String sql = "SELECT * FROM User";
        List<User> users = testDao.queryUser(sql, new Object[]{});
        List<String> userJsons = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(User user : users){
            try {
                userJsons.add(mapper.writeValueAsString(user));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return userJsons.toString();
    }

    @Override
    public String getCarByInfo(String info) { //车辆模糊查询
        String sql = "SELECT * FROM car WHERE carName LIKE ?";
        Object[] param = new Object[]{"%" + info + "%"};
        List<Car> cars = testDao.queryCarByInfo(sql, param);
        List<String> carJsons = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(Car car : cars){
            try {
                carJsons.add(mapper.writeValueAsString(car));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return carJsons.toString();
    }

    @Override
    public String login(String userName, String password) { // 新增的方法
        String sql = "SELECT * FROM User WHERE userName = ?";
        Object[] param = new Object[]{userName};
        User user = testDao.getUserByUserName(sql, param);
        if (user == null) {
            return "User does not exist";
        } else if (!user.getPassword().equals(password)) {
            return "Password is incorrect";
        } else {
            return "Login successful";
        }
    }

    @Override
    public String register(String userName, String password) { // 修改的方法
        String sql = "INSERT INTO User (userName, password, userType) VALUES (?, ?, 'NORMAL')";
        Object[] param = new Object[]{userName, password};
        int result = testDao.createUser(sql, param);
        if (result > 0) {
            return "User created successfully";
        } else {
            return "Failed to create user";
        }
    }

    @Override
    public String removeCar(int carID) { // 删除车子的方法
        String sql = "DELETE FROM Car WHERE carID = ?";
        Object[] param = new Object[]{carID};
        int result = testDao.deleteCar(sql, param);
        if (result > 0) {
            return "Car removed successfully";
        } else {
            return "Failed to remove car";
        }
    }

    @Override
    public String modifyCar(int carID, String carName, String rentalPrice, String carType, String carDescription) { // 新增的方法
        String sql = "UPDATE Car SET carName = ?, carPrice = ?, carType = ?, carDis = ? WHERE carID = ?";
        Object[] param = new Object[]{carName, rentalPrice, carType, carDescription, carID};
        int result = testDao.updateCar(sql, param);
        if (result > 0) {
            return "Car information updated successfully";
        } else {
            return "Failed to update car information";
        }
    }

    @Override
    public String modifyUser(int userID,String userName, String password, String userType) { // 新增的方法
        String sql = "UPDATE User SET userName = ?, password = ?, userType = ? WHERE userID = ?";
        Object[] param = new Object[]{userName, password, userType, userID};
        int result = testDao.updateUser(sql, param);
        if (result > 0) {
            return "User information updated successfully";
        } else {
            return "Failed to update user information";
        }
    }

    @Override
    public String removeUser(int userID) { // 新增的方法
        String sql = "DELETE FROM User WHERE userID = ?";
        Object[] param = new Object[]{userID};
        int result = testDao.deleteUser(sql, param);
        if (result > 0) {
            return "User removed successfully";
        } else {
            return "Failed to remove user";
        }
    }

    @Override
    public String getUserTypeByName(String userName) { // 新增的方法
        String sql = "SELECT userType FROM User WHERE userName = ?";
        Object[] param = new Object[]{userName};
        return testDao.getUserTypeByName(sql, param);
    }

    @Override
    public String getUserIDByName(String userName) {
        String sql = "SELECT userID FROM User WHERE userName = ?";
        Object[] param = new Object[]{userName};
        return testDao.getUserTypeByName(sql, param);
    }

    @Override
    public String updateCarRenter(int carID, int userID) {
        String sql = "UPDATE car SET renter = ?,carState = 'RENTED' WHERE carID = ?";
        Object[] param = new Object[]{userID,carID};
        int result = testDao.updateCarRenter(sql,param);
        if (result > 0) {
            return "car information updated successfully";
        } else {
            return "Failed to update car information";
        }
    }

    @Override
    public String addCar (String carName, String carPrice,String carType,String carDis,String userID) { // 修改的方法
        String sql = "INSERT INTO car (carName, carPrice, carType, carDis, carMaster, carState, renter) VALUES (?, ?, ?, ?, ?, 'AVAILABLE',0)";
        Object[] param = new Object[]{carName, carPrice, carType, carDis, userID};
        int result = testDao.createUser(sql, param);
        if (result > 0) {
            return "User created successfully";
        } else {
            return "Failed to create user";
        }
    }

}
