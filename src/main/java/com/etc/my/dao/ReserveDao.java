package com.etc.my.dao;



import com.etc.my.dto.ReserveDto;
import com.etc.my.dto.UpdateReserveDto;
import com.etc.my.entity.Reserve;

import java.util.List;
import java.util.Map;

public interface ReserveDao {
    /**
     * 添加预约信息
     * @param reserveDto
     * @return
     * @author yyb
     */
    boolean addReserve(ReserveDto reserveDto);

    /**
     * 根据id获取预约信息
     * @param id
     * @return
     */
    ReserveDto getReserve(Integer id);

    /**
     * 分页查询预约
     * @param
     * @return
     * @author yyb
     */
    List<Reserve> queryReserve(ReserveDto reserveDto);

    /**
     *查询预约总条数
     * @return
     * @author yyb
     */
    Long getReserveCount();

    /**
     * 修改预约信息
     * @param updateReserveDto
     * @return
     * @author yyb
     */
    boolean updateReserve(UpdateReserveDto updateReserveDto);


    /**
     * 获取预约信息
     * @param map
     * @return
     */
    List<ReserveDto> getAllReserve(ReserveDto reserveDto);
}
