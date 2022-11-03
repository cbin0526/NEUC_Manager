package com.etc.my.service;

import com.etc.my.vo.CarBrandnumVo;

import java.util.List;

public interface OrderService {

    public List<CarBrandnumVo> seletCarBrandAndNumByOrderTime(String car_datatime);
}
