package com.etc.my.dao;

import com.etc.my.entity.User;

import java.util.List;

public interface UserDao {

    List<User> queryAllUser();

    /**
     * 根据电话查询用户
     * @param user_phone
     * @return
     * @author ljw
     */
    User queryUser(String user_phone);

    /**
     * 根据名字和密码查询
     * @param user_name
     * @param user_pwd
     * @return
     */
    User check(String user_name,String user_pwd);


}
