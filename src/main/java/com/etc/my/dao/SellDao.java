package com.etc.my.dao;

import com.etc.my.dto.CountDto;
import com.etc.my.dto.SellOfKeysDto;
import com.etc.my.entity.Sell;

import java.util.List;

public interface SellDao {

    /**
     * 动态查询卖车预约
     * @param sokd 动态条件
     * @return
     */
    List<Sell> querySellByKeysOfPage(SellOfKeysDto sokd);

    /**
     * 查询动态的总条数
     * @param sokd
     * @return
     */
    CountDto querySellCount(SellOfKeysDto sokd);

    /**
     * 沟通
     * @param sellid
     * @return
     */
    boolean updateStatusById(Integer sellid);
}
