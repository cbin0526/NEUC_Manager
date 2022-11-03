package com.etc.my.service;


import com.etc.my.dto.CountDto;
import com.etc.my.dto.PushDto;
import com.etc.my.entity.Push;

import java.util.List;

public interface PushService {

    List<Push> selectAllPush(Integer page,Integer size);

    CountDto countAllPush();

    PushDto queryOnePushById(Integer push_id);

    boolean updatePushStatueAndCarid( String car_id,Integer push_id);
}
