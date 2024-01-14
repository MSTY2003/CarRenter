package com.software212.car.service;

public interface TestService {
    public String getCarById(int carID);//根据id查车子
    public String getCarInfo();//直接获取所有车子的信息
    public String getUserInfo(); //获取所有用户的信息
    public String getCarByInfo(String info); //获取满足条件的车辆信息
    public String login(String userName, String password); //登录
    public String register(String userName, String password); //注册
    public String removeCar(int carID); // 新增的方法，删除车辆
    public String modifyCar(int carID, String carName, String rentalPrice, String carType, String carDescription); // 新增的方法，修改车辆信息
    public String modifyUser(int userID,String userName, String password, String userType); // 新增的方法，修改用户信息
    public String removeUser(int userID); // 新增的方法，删除用户
    public String getUserTypeByName(String userName); // 新增的方法，获取用户类型
    public String getUserIDByName(String userName);
    public String updateCarRenter(int carID,int userID);
    public String addCar (String carName, String carPrice,String carType,String carDis,String userID);
}
