package com.etc.my.dao;

import com.etc.my.vo.CarBrandnumVo;

import java.util.List;

public interface OrderDao {

    /**
     * 根据订单的名称获取车辆品牌和数量
     * @param order_time
     * @return
     */
    List<CarBrandnumVo> seletCarBrandAndNumByOrderTime(String order_time);
}
