package com.etc.my.service.impl;


import com.etc.my.dao.PushDao;
import com.etc.my.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushServiceImpl implements PushService {
    @Autowired
    private PushDao dao;

    public PushDao getDao() {
        return dao;
    }

    public void setDao(PushDao dao) {
        this.dao = dao;
    }
}
