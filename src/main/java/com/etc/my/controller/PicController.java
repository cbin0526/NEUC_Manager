package com.etc.my.controller;

import com.etc.my.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PicController {
    @Autowired
    private PicService ps;

    public PicService getPs() {
        return ps;
    }

    public void setPs(PicService ps) {
        this.ps = ps;
    }
}
