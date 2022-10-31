package com.etc.my.service.impl;


import com.etc.my.dao.SellDao;
import com.etc.my.dto.CountDto;
import com.etc.my.dto.SellOfKeysDto;
import com.etc.my.entity.Sell;
import com.etc.my.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Sell> getSellByKeysOfPage(SellOfKeysDto sokd) {
        if(sokd!=null){
            return dao.querySellByKeysOfPage(sokd);
        }

        return null;
    }

    @Override
    public CountDto getSellCount(SellOfKeysDto sokd) {
        if(sokd!=null){
           return dao.querySellCount(sokd);
        }
        return null;
    }

    @Override
    public boolean updateStatusById(Integer sellid) {
        return dao.updateStatusById(sellid);
    }
}
