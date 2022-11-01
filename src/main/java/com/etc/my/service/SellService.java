package com.etc.my.service;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.SellOfKeysDto;
import com.etc.my.entity.Sell;

import java.util.List;

public interface SellService {

    /**
     * 动态查询卖车预约
     * @param sokd 动态条件
     * @return
     */
    List<Sell> getSellByKeysOfPage(SellOfKeysDto sokd);

    /**
     * 查询动态的总条数
     * @param sokd
     * @return
     */
    CountDto getSellCount(SellOfKeysDto sokd);

    /**
     * 沟通
     * @param sellid
     * @return
     */
    boolean updateStatusById(Integer sellid);
}
