package com.etc.my.dao;


import com.etc.my.dto.CarAndPicDto;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.PageDto;
import com.etc.my.entity.Car;
import com.etc.my.vo.CarBrandnumVo;

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


    /**
     * 获取车辆品牌和数量
     * @return
     */
    List<CarBrandnumVo> queryCarBrandAndNum();

    /**
     * 通过汽车名字品牌类型模糊查询
     * @param car_name
     * @param car_brand
     * @param car_dept
     * @return
     */
    List<Car> queryCarIdByNameBrandDept(String car_name,String car_brand,String car_dept);
}
