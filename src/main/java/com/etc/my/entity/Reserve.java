package com.etc.my.entity;

/**
 * 预约看车
 */
public class Reserve {

    private Integer reserve_id;//预约id
    private String reserve_phone;//预约电话
    private String reserve_date;//预约时间
    private User reserve_user;//预约用户
    private String reserv_status;//预约状态
    private Car reserve_car;//预约车辆

    public Integer getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(Integer reserve_id) {
        this.reserve_id = reserve_id;
    }

    public String getReserve_phone() {
        return reserve_phone;
    }

    public void setReserve_phone(String reserve_phone) {
        this.reserve_phone = reserve_phone;
    }

    public String getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(String reserve_date) {
        this.reserve_date = reserve_date;
    }

    public User getReserve_user() {
        return reserve_user;
    }

    public void setReserve_user(User reserve_user) {
        this.reserve_user = reserve_user;
    }

    public String getReserv_status() {
        return reserv_status;
    }

    public void setReserv_status(String reserv_status) {
        this.reserv_status = reserv_status;
    }

    public Car getReserve_car() {
        return reserve_car;
    }

    public void setReserve_car(Car reserve_car) {
        this.reserve_car = reserve_car;
    }
}
