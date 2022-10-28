package com.etc.my.controller;


import com.etc.my.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SellController {
    @Autowired
    private SellService ss;

    public SellService getSs() {
        return ss;
    }

    public void setSs(SellService ss) {
        this.ss = ss;
    }
}

