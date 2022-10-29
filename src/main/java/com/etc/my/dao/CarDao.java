package com.etc.my.dao;


import com.etc.my.dto.CarDto;
import com.etc.my.entity.Car;


public interface CarDao {
    /**
     * 添加车辆信息
     * @param car
     * @return
     * @author ljw 
     */
    boolean addCar(CarDto car);


    Car getCar(Integer id);
}
