package com.etc.my.service;


import com.etc.my.dto.CarAndPicDto;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.PicDto;
import com.etc.my.dto.PicDto2;
import com.etc.my.entity.Car;
import com.etc.my.vo.CarBrandnumVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;
import java.util.Map;

public interface CarService {

    /**
     * 添加车辆
     * @param car
     * @return
     * author ljw
     */
    boolean insertCar(CarDto car);

    /**
     * 同时添加图片和车辆信息
     * @param carDto
     * @param dto
     * @return
     * @throws Exception
     * author ljw
     */
    boolean addCarAndPic(CarDto carDto, PicDto2 dto)throws Exception;

    /**
     * 分页查询车辆
     * @param
     * @return
     * @author ljw
     */
    List<Car> queryCar(CarDto car);

    /**
     *查询车辆总条数
     * @return
     * @author ljw
     */
    Long getCarCount();

    /**
     * 根据车辆id查找车辆信息
     * @param id
     * @return
     * @author ljw
     */
    CarAndPicDto queryCar(String id);

    /**
     * 修改车辆信息
     * @param dto
     * @return
     * @author ljw
     */
    boolean updateCar(CarDto dto);


    /**
     * 同时修改图片和车辆信息
     * @param carDto
     * @param dto
     * @return
     * @throws Exception
     * author ljw
     */
    boolean updateCarAndPic(CarDto carDto, PicDto2 dto)throws Exception;

    /**
     * 车辆信息导成excle的方法
     * @param map
     * @return
     */
    HSSFWorkbook exportExcel(Map<String,Object> map);

    /**
     * 查询车辆品牌和数量
     * @return
     */
    List<CarBrandnumVo> queryCarBrandAndNum();
}
