package com.etc.my.service.impl;


import com.etc.my.dao.ReserveDao;
import com.etc.my.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveDao dao;

    public ReserveDao getDao() {
        return dao;
    }

    public void setDao(ReserveDao dao) {
        this.dao = dao;
    }
}
