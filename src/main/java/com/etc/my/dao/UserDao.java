package com.etc.my.dao;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.UserDto;
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

    User queryUserById(Integer id);

    /**
     * 修改用户状态：启用/禁用
     * @param user_id 用户id
     * @param user_status 新的状态
     * @return true/false
     */
    boolean updateUserStatus(Integer user_id,String user_status);

    /**
     * 多条件查询用户信息
     * @param user 条件
     * @return 符合用户条件的列表
     */
    List<User> queryUserByCondition(UserDto user);

    /**
     * 符合条件的的用户数量
     * @param user 用户
     * @return
     */
    CountDto getUserCount(UserDto user);
}
