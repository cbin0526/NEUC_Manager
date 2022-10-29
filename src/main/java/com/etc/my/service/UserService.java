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


}
