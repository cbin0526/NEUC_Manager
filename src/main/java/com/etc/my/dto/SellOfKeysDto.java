package com.etc.my.dto;

import com.etc.my.entity.User;

public class SellOfKeysDto {

    private String sell_phone;//卖车联系电话
    private String sell_address;//卖车地址
    private String sell_carname;//卖车的品牌名称
    private String sell_cardept;//卖车的系别
    private User sell_user;//预约卖车的用户
    private String sell_status;//沟通状态
    private Integer page;
    private Integer size;

    public String getSell_phone() {
        return sell_phone;
    }

    public void setSell_phone(String sell_phone) {
        this.sell_phone = sell_phone;
    }

    public String getSell_address() {
        return sell_address;
    }

    public void setSell_address(String sell_address) {
        this.sell_address = sell_address;
    }

    public String getSell_carname() {
        return sell_carname;
    }

    public void setSell_carname(String sell_carname) {
        this.sell_carname = sell_carname;
    }

    public String getSell_cardept() {
        return sell_cardept;
    }

    public void setSell_cardept(String sell_cardept) {
        this.sell_cardept = sell_cardept;
    }

    public User getSell_user() {
        return sell_user;
    }

    public void setSell_user(User sell_user) {
        this.sell_user = sell_user;
    }

    public String getSell_status() {
        return sell_status;
    }

    public void setSell_status(String sell_status) {
        this.sell_status = sell_status;
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
