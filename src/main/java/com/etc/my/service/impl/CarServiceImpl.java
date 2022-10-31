package com.etc.my.service.impl;



import com.etc.my.dao.CarDao;
import com.etc.my.dao.PicDao;
import com.etc.my.dto.CarAndPicDto;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.PicDto;
import com.etc.my.dto.PicDto2;
import com.etc.my.entity.Car;
import com.etc.my.entity.Pic;
import com.etc.my.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao dao;
    @Autowired
    private PicDao picDao;

    public PicDao getPicDao() {
        return picDao;
    }

    public void setPicDao(PicDao picDao) {
        this.picDao = picDao;
    }

    public CarDao getDao() {
        return dao;
    }

    public void setDao(CarDao dao) {
        this.dao = dao;
    }


    @Override
    public boolean insertCar(CarDto car) {

        return dao.addCar(car);



    }

    @Override
    @Transactional
    public boolean addCarAndPic(CarDto carDto, PicDto2 dto) throws Exception {


        boolean flag=dao.addCar(carDto);
        boolean flag2=picDao.addPic(dto);
        return flag&flag2;
    }

    @Override
    public List<Car> queryCar(CarDto car) {
        return dao.queryCar(car);
    }

    @Override
    public Long getCarCount() {
        return dao.getCarCount();
    }

    @Override
    public CarAndPicDto queryCar(String id) {
        if(id.equals("")&&id==null){
            return null;
        }
        return dao.getCar(id);
    }

    @Override
    public boolean updateCar(CarDto dto) {
        return dao.updateCar(dto);
    }

    @Override
    @Transactional
    public boolean updateCarAndPic(CarDto carDto, PicDto2 dto) throws Exception {
        boolean flag=dao.updateCar(carDto);
        boolean flag1=picDao.updatePic(dto);


        return flag&&flag1;
    }
}
