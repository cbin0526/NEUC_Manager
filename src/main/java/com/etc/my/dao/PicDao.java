package com.etc.my.dao;



import com.etc.my.dto.PicDto2;


public interface PicDao {

    /**
     * 添加图片库
     * @param
     * @return
     * @author ljw
     */

    boolean addPic(PicDto2 pic);

    /**
     * 根据id修改图片库
     * @param pic
     * @return
     * @author ljw
     */
    boolean updatePic(PicDto2 pic);
}
