package com.etc.my.service;


import com.etc.my.dto.CarDto;
import com.etc.my.dto.PicDto;
import com.etc.my.dto.PicDto2;

public interface CarService {

    /**
     * 添加车辆
     * @param car
     * @return
     * author ljw
     */
    boolean insertCar(CarDto car);


    boolean addCarAndPic(CarDto carDto, PicDto2 dto)throws Exception;
}
