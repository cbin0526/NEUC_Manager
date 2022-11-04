package com.etc.my.entity;

/**
 * 订单
 */
public class Order {

    private Integer order_id;//订单id
    private String order_code;//订单编号
    private String order_datetime;//订单生成时间
    private Car order_car;//下单车辆
    private User  order_user;//下单用户
    private String order_status;//订单状态
    private Double order_price;//订单价格
    private Integer page;
    private Integer size;

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

    public Car getOrder_car() {
        return order_car;
    }

    public void setOrder_car(Car order_car) {
        this.order_car = order_car;
    }

    public User getOrder_user() {
        return order_user;
    }

    public void setOrder_user(User order_user) {
        this.order_user = order_user;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }
}
