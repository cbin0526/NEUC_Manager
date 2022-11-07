package com.etc.my.dto;

import com.etc.my.entity.Car;
import com.etc.my.entity.User;

public class OrderDto {
    private Integer order_id;//订单id
    private String order_code;//订单编号
    private String order_datetime;//订单生成时间
    private String order_status;//订单状态
    private String order_price;//订单价格
    private String user_name;
    private String car_name;
    private Integer page;
    private Integer size;

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getOrder_datetime() {
        return order_datetime;
    }

    public void setOrder_datetime(String order_datetime) {
        this.order_datetime = order_datetime;
    }


    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
