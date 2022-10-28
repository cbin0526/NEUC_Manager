package com.etc.my.controller;


import com.etc.my.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Autowired
   private OrderService os;

    public OrderService getOs() {
        return os;
    }

    public void setOs(OrderService os) {
        this.os = os;
    }
}
