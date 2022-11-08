package com.etc.my.service;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.UserDto;
import com.etc.my.entity.User;
import org.apache.poi.ss.formula.functions.Count;

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

    /**
     * 修改用户账号状态 启用/禁用
     * @param user_id 用户id
     * @param user_status 改编后的状态
     * @return true/false
     */
    boolean changeUserStatus(Integer user_id,String user_status);

    /**
     * 根据多条件查询用户信息
     * @param user
     * @return
     */
    List<User> queryUserByCondition(UserDto user);

    /**
     * 符合多条件查询的用户数量
     * @param user 条件
     * @return 符合条件的用户数量
     */
    CountDto getUserCountWithCondition(UserDto user);
}
