package com.etc.my.service.impl;


import com.etc.my.dao.ReserveDao;
import com.etc.my.dto.ReserveDto;
import com.etc.my.entity.Reserve;
import com.etc.my.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public boolean addReserve(ReserveDto reserveDto) {
        if (reserveDto.getReserve_date()!=null&&reserveDto.getReserve_phone()!=null){
            return dao.addReserve(reserveDto);
        }
        return false;
    }

    @Override
    public ReserveDto getReserve(Integer id) {
        return dao.getReserve(id);
    }

    @Override
    public List<Reserve> queryReserve(ReserveDto reserveDto) {
        return dao.queryReserve(reserveDto);
    }


    @Override
    public Long getReserveCount() {
        return dao.getReserveCount();
    }

    @Override
    public boolean updateReserve(ReserveDto reserveDto) {
        return dao.updateReserve(reserveDto);
    }

    @Override
    public List<ReserveDto> getAllReserve(ReserveDto reserveDto) {
        return dao.getAllReserve(reserveDto);
    }
}
