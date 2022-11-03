package com.etc.my.service.impl;


import com.etc.my.dao.CarDao;
import com.etc.my.dao.PushDao;
import com.etc.my.dto.CountDto;
import com.etc.my.dto.PushDto;
import com.etc.my.entity.Push;
import com.etc.my.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushServiceImpl implements PushService {
    @Autowired
    private PushDao dao;
    @Autowired
    private CarDao carDao;

    public PushDao getDao() {
        return dao;
    }

    public void setDao(PushDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Push> selectAllPush(Integer page,Integer size) {
        page = (page - 1) * size;
        return dao.selectAllPush(page,size);
    }

    @Override
    public CountDto countAllPush() {
        return dao.countAllPush();
    }

    @Override
    public PushDto queryOnePushById(Integer push_id) {
        if (push_id == null | push_id <= 0){
            return null;
        }
        return dao.queryOnePushById(push_id);
    }

    @Override
    public boolean updatePushStatueAndCarid( String car_id,Integer push_id) {
        if(push_id == null | car_id == null){
            return false;
        }
        return dao.updatePushStatueAndCarid(car_id,push_id);
    }
}
