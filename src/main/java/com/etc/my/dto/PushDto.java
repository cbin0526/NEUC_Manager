package com.etc.my.dto;

import com.etc.my.entity.Car;
import com.etc.my.entity.User;

/**
 * @author: Admin
 * @time: 2022/11/3 17:32
 */

public class PushDto {

    private Integer push_id;//推送id
    private String push_carname;//想要的车辆名称
    private String push_brand;//想要的品牌
    private String push_dept;//想要的车系
    private Double push_price;//想要的价格
    private User push_user;//推送的用户
    private String push_status;//推送的状态
    private String push_car;//推送的车辆

    public Integer getPush_id() {
        return push_id;
    }

    public void setPush_id(Integer push_id) {
        this.push_id = push_id;
    }

    public String getPush_carname() {
        return push_carname;
    }

    public void setPush_carname(String push_carname) {
        this.push_carname = push_carname;
    }

    public String getPush_brand() {
        return push_brand;
    }

    public void setPush_brand(String push_brand) {
        this.push_brand = push_brand;
    }

    public String getPush_dept() {
        return push_dept;
    }

    public void setPush_dept(String push_dept) {
        this.push_dept = push_dept;
    }

    public Double getPush_price() {
        return push_price;
    }

    public void setPush_price(Double push_price) {
        this.push_price = push_price;
    }

    public User getPush_user() {
        return push_user;
    }

    public void setPush_user(User push_user) {
        this.push_user = push_user;
    }

    public String getPush_status() {
        return push_status;
    }

    public void setPush_status(String push_status) {
        this.push_status = push_status;
    }

    public String getPush_car() {
        return push_car;
    }

    public void setPush_car(String push_car) {
        this.push_car = push_car;
    }
}
