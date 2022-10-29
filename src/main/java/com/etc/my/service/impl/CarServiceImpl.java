package com.etc.my.service.impl;



import com.etc.my.dao.CarDao;
import com.etc.my.dao.PicDao;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.PicDto;
import com.etc.my.dto.PicDto2;
import com.etc.my.entity.Pic;
import com.etc.my.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
