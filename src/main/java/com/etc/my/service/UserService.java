package com.etc.my.service;

import com.etc.my.entity.User;

import java.util.List;

public interface UserService {


    List<User> getAllUser();

    /**
     * 根据联系电话
     * @param user_phone
     * @return
     * @author ljw
     */
    User getUser(String user_phone);

    /**
     * 根据姓名和密码查询用户
     * @param user_name
     * @param user_pwd
     * @return
     */
    User checkLogin(String user_name,String user_pwd);


}
