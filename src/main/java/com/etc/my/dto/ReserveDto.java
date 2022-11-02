package com.etc.my.dto;

public class ReserveDto {
    private Integer reserve_id;//预约id
    private String reserve_phone;//预约电话
    private String reserve_date;//预约时间
    private String user_name;//预约用户
    private String reserv_status;//预约状态
    private String car_name;//预约车辆
    private Integer page;
    private Integer size;
    private Integer maxPage;


    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
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

    public String getReserv_status() {
        return reserv_status;
    }

    public void setReserv_status(String reserv_status) {
        this.reserv_status = reserv_status;
    }

}
