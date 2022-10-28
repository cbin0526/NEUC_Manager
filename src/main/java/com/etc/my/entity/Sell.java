package com.etc.my.entity;

/**
 * 我要卖的车
 */
public class Sell {

    private  Integer sell_id;//卖车信息表id
    private String sell_phone;//卖车联系电话
    private String sell_address;//卖车地址
    private String sell_carname;//卖车的品牌名称
    private String sell_cardept;//卖车的系别

    public Integer getSell_id() {
        return sell_id;
    }

    public void setSell_id(Integer sell_id) {
        this.sell_id = sell_id;
    }

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
}
