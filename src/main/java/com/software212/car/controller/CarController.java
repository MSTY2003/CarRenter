package com.software212.car.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.software212.car.service.TestService;

import java.util.HashMap;
import java.util.Map;
// 其他类似的注解...


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private TestService testService;

    //所有车辆查询
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getAllCars")
    public String getAllCars() {
        System.out.println("cars!");
        return testService.getCarInfo();
    }

    //所有用户查询
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getAllUsers")
    public String getAllUsers() {
        System.out.println("Users!");
        return testService.getUserInfo();
    }

    //车辆id查询
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getCar/{id}")
    public String getCar(@PathVariable int id) {
        return testService.getCarById(id);
    }

    //车辆模糊查询
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getCarByInfo/{info}")
    public String getCarByInfo(@PathVariable String info) {
        return testService.getCarByInfo(info);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String userName = credentials.get("userName");
        String password = credentials.get("password");
        return testService.login(userName, password);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> credentials) {
        String userName = credentials.get("userName");
        String password = credentials.get("password");
        return testService.register(userName, password);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/removeCar/{id}")
    public String removeCar(@PathVariable int id) {
        return testService.removeCar(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/modifyCar/{id}")
    public String modifyCar(@PathVariable int id, @RequestBody Map<String, Object> carInfo) {
        String carName = (String) carInfo.get("carName");
        String rentalPrice = (String) carInfo.get("rentalPrice");
        String carType = (String) carInfo.get("carType");
        String carDescription = (String) carInfo.get("carDescription");
        return testService.modifyCar(id, carName, rentalPrice, carType, carDescription);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/modifyUser/{id}")
    public String modifyUser(@PathVariable int id, @RequestBody Map<String, String> userInfo) {
        String userName = userInfo.get("userName");
        String password = userInfo.get("password");
        String userType = userInfo.get("userType");
        return testService.modifyUser(id, userName,password, userType);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("/removeUser/{id}")
    public String removeUser(@PathVariable int id) {
        return testService.removeUser(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getUserType/{userName}")
    public String getUserType(@PathVariable String userName) {
        return testService.getUserTypeByName(userName);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getUserID/{userName}")
    public String getUserID(@PathVariable String userName) {
        return testService.getUserIDByName(userName);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PutMapping("/updateCarRanter/{carID}/{userID}")
    public String updateCarRanter(@PathVariable int carID, @PathVariable int userID) {
        return testService.updateCarRenter(carID,userID);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/addCar")
    public String addCar(@RequestBody Map<String, String> credentials) {
        String carName = credentials.get("carName");
        String carPrice = credentials.get("carPrice");
        String carType = credentials.get("carType");
        String carDis = credentials.get("carDis");
        String userID = credentials.get("userID");

        return testService.addCar(carName,carPrice,carType,carDis,userID);
    }
}
