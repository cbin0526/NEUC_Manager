package com.etc.my.controller;

import com.etc.my.service.ReserveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReserveController {
    @Autowired
    private ReserveService rs;

    public ReserveService getRs() {
        return rs;
    }

    public void setRs(ReserveService rs) {
        this.rs = rs;
    }
}
