package com.software212.car.dao;

import entity.Car;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl implements TestDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int update(String sql, Object[] param) {
        return jdbcTemplate.update(sql, param);
    }

    //查询车辆信息
    @Override
    public List<Car> query(String sql, Object[] param) {
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<Car>(Car.class);
        return jdbcTemplate.query(sql, param, rowMapper);
    }

    //查询用户信息
    @Override
    public List<User> queryUser(String sql, Object[] param) { // 新增的方法
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.query(sql, param, rowMapper);
    }

    //根据车辆信息模糊查询
    @Override
    public List<Car> queryCarByInfo(String sql,Object[] param) { // 新增的方法
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<Car>(Car.class);
        return jdbcTemplate.query(sql, param, rowMapper);
    }

    //根据用户名查询用户
    @Override
    public User getUserByUserName(String sql,Object[] param) { // 新增的方法
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = jdbcTemplate.query(sql, param, rowMapper);
        return users.isEmpty() ? null : users.get(0);
    }

    //在数据库中创建新用户
    @Override
    public int createUser(String sql,Object[] param) { // 新增的方法
        return jdbcTemplate.update(sql, param);
    }

    //在数据库中删除车辆
    @Override
    public int deleteCar(String sql,Object[] param) { // 新增的方法
        return jdbcTemplate.update(sql, param);
    }

    //在数据库中修改车辆信息
    @Override
    public int updateCar(String sql,Object[] param) { // 新增的方法
        return jdbcTemplate.update(sql, param);
    }

    //在数据库中修改用户信息
    @Override
    public int updateUser(String sql,Object[] param) { // 新增的方法
        return jdbcTemplate.update(sql, param);
    }

    //在数据库中删除用户
    @Override
    public int deleteUser(String sql,Object[] param) { // 新增的方法
        return jdbcTemplate.update(sql, param);
    }

    //根据用户名查询用户类型
    @Override
    public String getUserTypeByName(String sql,Object[] param) { // 新增的方法
        return jdbcTemplate.queryForObject(sql, param, String.class);
    }

    @Override
    public int updateCarRenter(String sql, Object[] param) {
        return jdbcTemplate.update(sql, param);
    }


}
