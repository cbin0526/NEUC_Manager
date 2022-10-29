package com.etc.my.service.impl;


import com.etc.my.dao.PicDao;
import com.etc.my.dto.PicDto2;
import com.etc.my.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicServiceImpl implements PicService {
    @Autowired
    private PicDao dao;

    public PicDao getDao() {
        return dao;
    }

    public void setDao(PicDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean insertPic(PicDto2 picDto) {
        return dao.addPic(picDto);
    }
}
