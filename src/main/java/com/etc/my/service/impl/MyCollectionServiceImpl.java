package com.etc.my.service.impl;

import com.etc.my.dao.MyCollectionDao;
import com.etc.my.service.MyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyCollectionServiceImpl implements MyCollectionService {
    @Autowired
    private MyCollectionDao dao;

    public MyCollectionDao getDao() {
        return dao;
    }

    public void setDao(MyCollectionDao dao) {
        this.dao = dao;
    }
}
