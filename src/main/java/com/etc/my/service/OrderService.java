package com.etc.my.service;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.OrderDto;
import com.etc.my.entity.Order;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;
import java.util.Map;

import com.etc.my.vo.CarBrandnumVo;

import java.util.List;

public interface OrderService {
    //获取订单
    List<Order> getOrder(OrderDto order);
    //获取订单条数
    CountDto getOrderCunt(OrderDto order);

    /**
     * 将订单信息导成excle的方法
     * @param map
     * @return
     */
    HSSFWorkbook exportExcel(Map<String,Object> map);

    public List<CarBrandnumVo> seletCarBrandAndNumByOrderTime(String car_datatime);
}
