package com.etc.my.service.impl;

import com.etc.my.dao.CarDao;
import com.etc.my.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao dao;

    public CarDao getDao() {
        return dao;
    }

    public void setDao(CarDao dao) {
        this.dao = dao;
    }
}
