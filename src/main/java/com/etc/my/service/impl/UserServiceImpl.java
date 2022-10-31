package com.etc.my.service.impl;

import com.etc.my.dao.UserDao;
import com.etc.my.entity.User;
import com.etc.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }



    @Override
    public List<User> getAllUser() {
        return dao.queryAllUser();
    }

    @Override
    public User getUser(String user_phone) {
        if(user_phone==null){
            return null;
        }else{
            return dao.queryUser(user_phone);
        }

    }


    @Override
    public User checkLogin(String user_name, String user_pwd) {
        if(user_name==null&&user_pwd==null){
            return null;
        }
        return dao.check(user_name,user_pwd);
    }
}
