package com.etc.my.entity;

/**
 * 我想要的推送
 */
public class Push {

    private Integer push_id;//推送id
    private String push_carname;//想要的车辆名称
    private String push_brand;//想要的品牌
    private String push_dept;//想要的车系
    private Double push_price;//想要的价格
    private User push_user;//推送的用户
    private String push_status;//推送的状态

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
}
