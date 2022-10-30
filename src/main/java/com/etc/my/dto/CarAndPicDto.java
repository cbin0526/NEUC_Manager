package com.etc.my.dto;

import com.etc.my.entity.Car;
import com.etc.my.entity.User;

/**
 * 汽车信息
 */
public class CarAndPicDto {

    private Integer car_id;//车辆id
    private String car_name;//车辆名称
    private String car_brand;//车辆品牌
    private String car_dept;//车辆系别
    private Double car_price;//车辆价格
    private String car_regist;//上牌时间
    private Double car_mile;//车辆表总里程
    private String car_at;//车辆变速箱
    private Double car_dc;//车辆排量
    private Double car_newprice;//车辆新车价格
    private Integer car_transfer;//车辆过户次数
    private String car_power;//车辆总功率
    private String car_adress;//车辆地址
    private String car_endurance;//车辆续航里程
    private Integer car_capacity;//车辆电池容量
    private String car_color;//车辆颜色
    private String car_producetime;//车辆产出时间
    private Integer car_keynum;//车辆钥匙数量
    private Integer page;
    private Integer size;
    private String key="";
    private Integer car_sale;//卖家
    private Integer car_buy;//买家
    private String car_status;//状态
    private String car_time;//上架时间
    private Integer pic_id;//图片id
    private String pic_main;//车辆主图
    private String pic_appea1;//车辆外观1
    private String pic_appea2;//车辆外观2
    private String pic_interior1;//车辆内饰1
    private String  pic_interior2;//车辆内饰2
    private Integer pic_car;//车辆id
    private String user_phone;//联系电话

    public Integer getCar_sale() {
        return car_sale;
    }

    public Integer getCar_buy() {
        return car_buy;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setCar_sale(Integer car_sale) {
        this.car_sale = car_sale;
    }

    public void setCar_buy(Integer car_buy) {
        this.car_buy = car_buy;
    }

    public Integer getPic_id() {
        return pic_id;
    }

    public void setPic_id(Integer pic_id) {
        this.pic_id = pic_id;
    }

    public String getPic_main() {
        return pic_main;
    }

    public void setPic_main(String pic_main) {
        this.pic_main = pic_main;
    }

    public String getPic_appea1() {
        return pic_appea1;
    }

    public void setPic_appea1(String pic_appea1) {
        this.pic_appea1 = pic_appea1;
    }

    public String getPic_appea2() {
        return pic_appea2;
    }

    public void setPic_appea2(String pic_appea2) {
        this.pic_appea2 = pic_appea2;
    }

    public String getPic_interior1() {
        return pic_interior1;
    }

    public void setPic_interior1(String pic_interior1) {
        this.pic_interior1 = pic_interior1;
    }

    public String getPic_interior2() {
        return pic_interior2;
    }

    public void setPic_interior2(String pic_interior2) {
        this.pic_interior2 = pic_interior2;
    }

    public Integer getPic_car() {
        return pic_car;
    }

    public void setPic_car(Integer pic_car) {
        this.pic_car = pic_car;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_dept() {
        return car_dept;
    }

    public void setCar_dept(String car_dept) {
        this.car_dept = car_dept;
    }

    public Double getCar_price() {
        return car_price;
    }

    public void setCar_price(Double car_price) {
        this.car_price = car_price;
    }

    public String getCar_regist() {
        return car_regist;
    }

    public void setCar_regist(String car_regist) {
        this.car_regist = car_regist;
    }

    public Double getCar_mile() {
        return car_mile;
    }

    public void setCar_mile(Double car_mile) {
        this.car_mile = car_mile;
    }

    public String getCar_at() {
        return car_at;
    }

    public void setCar_at(String car_at) {
        this.car_at = car_at;
    }

    public Double getCar_newprice() {
        return car_newprice;
    }

    public void setCar_newprice(Double car_newprice) {
        this.car_newprice = car_newprice;
    }

    public Double getCar_dc() {
        return car_dc;
    }

    public void setCar_dc(Double car_dc) {
        this.car_dc = car_dc;
    }



    public Integer getCar_transfer() {
        return car_transfer;
    }

    public void setCar_transfer(Integer car_transfer) {
        this.car_transfer = car_transfer;
    }

    public String getCar_power() {
        return car_power;
    }

    public void setCar_power(String car_power) {
        this.car_power = car_power;
    }

    public String getCar_adress() {
        return car_adress;
    }

    public void setCar_adress(String car_adress) {
        this.car_adress = car_adress;
    }

    public String getCar_endurance() {
        return car_endurance;
    }

    public void setCar_endurance(String car_endurance) {
        this.car_endurance = car_endurance;
    }

    public Integer getCar_capacity() {
        return car_capacity;
    }

    public void setCar_capacity(Integer car_capacity) {
        this.car_capacity = car_capacity;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_producetime() {
        return car_producetime;
    }

    public void setCar_producetime(String car_producetime) {
        this.car_producetime = car_producetime;
    }

    public Integer getCar_keynum() {
        return car_keynum;
    }

    public void setCar_keynum(Integer car_keynum) {
        this.car_keynum = car_keynum;
    }


    public String getCar_status() {
        return car_status;
    }

    public void setCar_status(String car_status) {
        this.car_status = car_status;
    }

    public String getCar_time() {
        return car_time;
    }

    public void setCar_time(String car_time) {
        this.car_time = car_time;
    }
}
