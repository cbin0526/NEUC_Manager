package com.etc.my.dao;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.PushDto;
import com.etc.my.entity.Push;

import java.util.List;

public interface PushDao {

    /**
     * 分页查询全部的推送
     * @param page
     * @param size
     * @return
     */
    List<Push> selectAllPush(Integer page,Integer size);

    /**
     * 查询推送表的总字段
     * @return
     */
    CountDto countAllPush();

    /**
     * 通过id查推送表
     * @param push_id
     * @return
     */
    PushDto queryOnePushById(Integer push_id);

    /**
     *
     * @param car_id
     * @param push_id
     * @return
     */
    boolean updatePushStatueAndCarid(String car_id,Integer push_id);
}
