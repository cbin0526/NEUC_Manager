package com.etc.my.service.impl;


import com.etc.my.dao.SellDao;
import com.etc.my.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellServiceImpl implements SellService {
    @Autowired
    private SellDao dao;

    public SellDao getDao() {
        return dao;
    }

    public void setDao(SellDao dao) {
        this.dao = dao;
    }
}
