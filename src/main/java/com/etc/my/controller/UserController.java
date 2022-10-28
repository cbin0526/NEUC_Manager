package com.etc.my.controller;


import com.etc.my.dto.MyMessage;
import com.etc.my.entity.User;
import com.etc.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    public UserService getUs() {
        return us;
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public MyMessage getAllUser(){
        MyMessage message = new MyMessage();
        List<User> list = us.getAllUser();

        message.setData(list);
        return message;
    }



}
