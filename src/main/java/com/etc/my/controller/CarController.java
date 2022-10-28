package com.etc.my.controller;


import com.etc.my.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CarController {
    @Autowired
    private CarService cs;

    public CarService getCs() {
        return cs;
    }

    public void setCs(CarService cs) {
        this.cs = cs;
    }
}
