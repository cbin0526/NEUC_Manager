package com.etc.my.service.impl;

import com.etc.my.dao.OrderDao;
import com.etc.my.service.OrderService;
import com.etc.my.vo.CarBrandnumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;

    public OrderDao getDao() {
        return dao;
    }

    public void setDao(OrderDao dao) {
        this.dao = dao;
    }


   public List<CarBrandnumVo> seletCarBrandAndNumByOrderTime(String car_datatime){
        if(car_datatime == null){
            car_datatime = "";
        }
        car_datatime = "%"+car_datatime+"%";
        List<CarBrandnumVo> carBrandnumVos = dao.seletCarBrandAndNumByOrderTime(car_datatime);
        return carBrandnumVos;
   }

}
