package com.etc.my.dao;


import com.etc.my.dto.CarAndPicDto;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.PageDto;
import com.etc.my.entity.Car;

import java.util.List;
import java.util.Map;


public interface CarDao {
    /**
     * 添加车辆信息
     * @param car
     * @return
     * @author ljw 
     */
    boolean addCar(CarDto car);

    /**
     * 根据id获取车辆信息
     * @param id
     * @return
     */
    CarAndPicDto getCar(String id);

    /**
     * 分页查询车辆
     * @param
     * @return
     * @author ljw
     */
    List<Car> queryCar(CarDto car);

    /**
     *查询车辆总条数
     * @return
     * @author ljw
     */
    Long getCarCount();

    /**
     * 修改车辆信息
     * @param dto
     * @return
     * @author ljw
     */
    boolean updateCar(CarDto dto);


    /**
     * 获取车辆信息
     * @param map
     * @return
     */
    List<CarDto> getAllCar(Map<String, Object> map);


}
