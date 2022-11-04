package com.etc.my.dao;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.OrderDto;
import com.etc.my.entity.Order;
import com.etc.my.vo.CarBrandnumVo;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    List<Order> queryOrder(OrderDto order) ;

    CountDto queryOrderCount(OrderDto order);


    /**
     * 获取所有订单信息导出excel表
     * @param map
     * @return
     */
    List<OrderDto> queryAllOrder(Map<String,Object> map);

    /**
     * 根据订单的名称获取车辆品牌和数量
     * @param order_time
     * @return
     */
    List<CarBrandnumVo> seletCarBrandAndNumByOrderTime(String order_time);
}
