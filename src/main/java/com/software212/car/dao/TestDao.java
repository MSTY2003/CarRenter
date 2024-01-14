package com.software212.car.dao;

import entity.Car;
import entity.User;

import java.util.List;

public interface TestDao {
    public int update(String sql,Object[] param);
    public List<Car> query(String sql,Object[] param);
    public List<User> queryUser(String sql, Object[] param);
    public List<Car> queryCarByInfo(String sql,Object[] param);
    public User getUserByUserName(String sql,Object[] param);
    public int createUser(String sql,Object[] param);
    public int deleteCar(String sql,Object[] param);
    public int updateCar(String sql,Object[] param);
    public int updateUser(String sql,Object[] param);
    public int deleteUser(String sql,Object[] param); // 新增的方法
    public String getUserTypeByName(String sql,Object[] param);
    public int updateCarRenter(String sql,Object[] param);
}
