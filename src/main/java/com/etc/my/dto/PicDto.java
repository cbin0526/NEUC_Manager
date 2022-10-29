package com.etc.my.dto;


import com.etc.my.entity.Car;
import org.springframework.web.multipart.MultipartFile;

public class PicDto {

    private Integer pic_id;//图片id
    private MultipartFile pic_main;//车辆主图
    private MultipartFile pic_appea1;//车辆外观1
    private MultipartFile pic_appea2;//车辆外观2
    private MultipartFile pic_interior1;//车辆内饰1
    private MultipartFile pic_interior2;//车辆内饰2
    private Integer pic_car;//车辆id

    public Integer getPic_id() {
        return pic_id;
    }

    public void setPic_id(Integer pic_id) {
        this.pic_id = pic_id;
    }

    public MultipartFile getPic_main() {
        return pic_main;
    }

    public void setPic_main(MultipartFile pic_main) {
        this.pic_main = pic_main;
    }

    public MultipartFile getPic_appea1() {
        return pic_appea1;
    }

    public void setPic_appea1(MultipartFile pic_appea1) {
        this.pic_appea1 = pic_appea1;
    }

    public MultipartFile getPic_appea2() {
        return pic_appea2;
    }

    public void setPic_appea2(MultipartFile pic_appea2) {
        this.pic_appea2 = pic_appea2;
    }

    public MultipartFile getPic_interior1() {
        return pic_interior1;
    }

    public void setPic_interior1(MultipartFile pic_interior1) {
        this.pic_interior1 = pic_interior1;
    }

    public MultipartFile getPic_interior2() {
        return pic_interior2;
    }

    public void setPic_interior2(MultipartFile pic_interior2) {
        this.pic_interior2 = pic_interior2;
    }

    public Integer getPic_car() {
        return pic_car;
    }

    public void setPic_car(Integer pic_car) {
        this.pic_car = pic_car;
    }
}
