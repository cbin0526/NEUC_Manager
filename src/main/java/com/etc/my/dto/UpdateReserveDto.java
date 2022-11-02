package com.etc.my.dto;

public class UpdateReserveDto {
    private String reserve_phone;//预约电话
    private String reserve_date;//预约时间
    private String reserv_status;//预约状态
    private Integer reserve_id;

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

    public String getReserv_status() {
        return reserv_status;
    }

    public void setReserv_status(String reserv_status) {
        this.reserv_status = reserv_status;
    }
}
