package com.etc.my.entity;

/**
 * 我的收藏
 */
public class MyCollection {

    private Integer collection_id;//收藏id
    private User  collection_user;//收藏用户
    private Car collection_car;//收藏车辆
    private String collection_status;//收藏状态

    public Integer getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Integer collection_id) {
        this.collection_id = collection_id;
    }

    public User getCollection_user() {
        return collection_user;
    }

    public void setCollection_user(User collection_user) {
        this.collection_user = collection_user;
    }

    public Car getCollection_car() {
        return collection_car;
    }

    public void setCollection_car(Car collection_car) {
        this.collection_car = collection_car;
    }

    public String getCollection_status() {
        return collection_status;
    }

    public void setCollection_status(String collection_status) {
        this.collection_status = collection_status;
    }
}
