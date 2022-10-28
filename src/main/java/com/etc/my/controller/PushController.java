package com.etc.my.controller;


import com.etc.my.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PushController {


    @Autowired
   private PushService pushs;
    public PushService getPushs() {
        return pushs;
    }

    public void setPushs(PushService pushs) {
        this.pushs = pushs;
    }

}
