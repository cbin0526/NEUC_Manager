package com.etc.my.controller;


import com.etc.my.service.MyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyCollectionController {
    @Autowired
   private MyCollectionService mcs;

    public MyCollectionService getMcs() {
        return mcs;
    }

    public void setMcs(MyCollectionService mcs) {
        this.mcs = mcs;
    }
}
