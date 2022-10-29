package com.etc.my.dao;

import com.etc.my.entity.User;

import java.util.List;

public interface UserDao {

    List<User> queryAllUser();

    User queryUser(String user_phone);


}
