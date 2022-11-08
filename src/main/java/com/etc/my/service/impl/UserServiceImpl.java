package com.etc.my.service.impl;

import com.etc.my.dao.UserDao;
import com.etc.my.dto.CountDto;
import com.etc.my.dto.UserDto;
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

    @Override
    public boolean changeUserStatus(Integer user_id, String user_status) {
        if(user_id==null || user_id<0 || user_status==null){
            System.out.println("user_id 或者user_status参数有误");
            return false;
        }else{
            return dao.updateUserStatus(user_id,user_status);
        }
    }

    @Override
    public List<User> queryUserByCondition(UserDto user) {
        return dao.queryUserByCondition(user);
    }

    @Override
    public CountDto getUserCountWithCondition(UserDto user) {
       return dao.getUserCount(user);
    }
}
