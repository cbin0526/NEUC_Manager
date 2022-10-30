package com.etc.my.service;


import com.etc.my.dto.PicDto2;

public interface PicService {

    /**
     * 添加图片库信息
     * @param picDto
     * @return
     * @author ljw
     *
     */
    boolean insertPic(PicDto2 picDto);

    /**
     * 修改图片库信息
     * @param pic
     * @return
     *  @author ljw
     */
    boolean updatePic(PicDto2 pic);
}
