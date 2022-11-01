package com.etc.my.service.impl;


import com.etc.my.dao.CarDao;
import com.etc.my.dao.PicDao;
import com.etc.my.dto.CarAndPicDto;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.PicDto;
import com.etc.my.dto.PicDto2;
import com.etc.my.entity.Car;
import com.etc.my.entity.Pic;
import com.etc.my.service.CarService;
import javafx.scene.text.Font;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao dao;
    @Autowired
    private PicDao picDao;

    public PicDao getPicDao() {
        return picDao;
    }

    public void setPicDao(PicDao picDao) {
        this.picDao = picDao;
    }

    public CarDao getDao() {
        return dao;
    }

    public void setDao(CarDao dao) {
        this.dao = dao;
    }


    @Override
    public boolean insertCar(CarDto car) {

        return dao.addCar(car);


    }

    @Override
    @Transactional
    public boolean addCarAndPic(CarDto carDto, PicDto2 dto) throws Exception {


        boolean flag = dao.addCar(carDto);
        boolean flag2 = picDao.addPic(dto);
        return flag & flag2;
    }

    @Override
    public List<Car> queryCar(CarDto car) {
        return dao.queryCar(car);
    }

    @Override
    public Long getCarCount() {
        return dao.getCarCount();
    }

    @Override
    public CarAndPicDto queryCar(String id) {
        if (id.equals("") && id == null) {
            return null;
        }
        return dao.getCar(id);
    }

    @Override
    public boolean updateCar(CarDto dto) {
        return dao.updateCar(dto);
    }

    @Override
    @Transactional
    public boolean updateCarAndPic(CarDto carDto, PicDto2 dto) throws Exception {
        boolean flag = dao.updateCar(carDto);
        boolean flag1 = picDao.updatePic(dto);


        return flag && flag1;
    }

    @Override
    public HSSFWorkbook exportExcel(Map<String, Object> map) {
        //获取需要生成excel的数据
        List<CarDto> list = dao.getAllCar(map);
        //判断是否为空
        if (list == null) {
            return null;
        }

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建一个excel的sheet
        HSSFSheet sheet = hssfWorkbook.createSheet("firstshett");
        //表头属性名
        String[] propertyName = {"序号", "车辆名称", "车辆品牌", "车辆系别", "车辆价格", "上牌时间", "车辆表总里程", "车辆变速箱", "车辆排量", "车辆新车价格（万）", "车辆过户次数"
                , "车辆总功率", "车辆地址", "车辆续航里程", "车辆电池容量", "车辆颜色", "车辆生产时间", "车辆状态", "上架时间", "车辆钥匙数量"};
        //获取表所需要的数量
        int length = propertyName.length;
        //-------设置第一行---------
        //设置行下面为第一行
        HSSFRow row = sheet.createRow(0);
        //设置列下面为第一行的第一列
        HSSFCell hssfCell = row.createCell(0);


        //设置字体
        HSSFFont hssfFont = hssfWorkbook.createFont();
        hssfFont.setFontName("黑体");
        //字体大小
        hssfFont.setFontHeightInPoints((short) 12);
        //设置样式
        HSSFCellStyle hssfCellStyle = hssfWorkbook.createCellStyle();
        //使用上面的字体样式
        hssfCellStyle.setFont(hssfFont);
        hssfCellStyle.setLocked(true);
        //自动换行
        hssfCellStyle.setWrapText(false);
        CellRangeAddress rangeAddress = new CellRangeAddress(0, 0, 0, length - 1);
        //把合并单元格设置进去
        sheet.addMergedRegion(rangeAddress);
        //设置样式
        hssfCell.setCellStyle(hssfCellStyle);
        hssfCell.setCellValue("车辆列表信息");
        //----------设置第二行-----------
        HSSFRow row2 = sheet.createRow(1);
        //字段名的字体
        HSSFFont hssfFont1 = hssfWorkbook.createFont();
        hssfFont1.setFontName("宋体");
        //字体大小
        hssfFont1.setFontHeightInPoints((short) 12);
        //列表样式
        HSSFCellStyle hssfCellStyle1 = hssfWorkbook.createCellStyle();
        //设置字体字体样式
        hssfCellStyle1.setFont(hssfFont1);
        hssfCellStyle1.setLocked(true);
        hssfCellStyle1.setWrapText(false);

        //设置行高
        row2.setHeight((short) 750);
        //创建列
        HSSFCell cell = null;
        for (int i = 0; i < length; i++) {
            cell = row2.createCell(i);
            //设置字段名
            cell.setCellValue(propertyName[i]);
            //设置样式
            cell.setCellStyle(hssfCellStyle1);
            //----设置表里面的内容--------------
            //设置字体
            HSSFFont font=hssfWorkbook.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short)10);
            //设置样式
            HSSFCellStyle hssfCellStyle2=hssfWorkbook.createCellStyle();
            hssfCellStyle2.setFont(font);
            hssfCellStyle2.setWrapText(true);
            HSSFRow hssfRow=null;
            HSSFCell hssfCell1=null;
            int valueStatrRow=2;
            //赋值
            for (CarDto cardto:list
                 ) {
                hssfRow=sheet.createRow(valueStatrRow);
                //id
                hssfCell1=hssfRow.createCell(0);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_id());
                //车辆名称
                hssfCell1=hssfRow.createCell(1);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_name());
                //车辆品牌
                hssfCell1=hssfRow.createCell(2);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_brand());
                //车辆系别
                hssfCell1=hssfRow.createCell(3);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_dept());
                //车辆价格
                hssfCell1=hssfRow.createCell(4);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_price());
                //车辆上牌时间
                hssfCell1=hssfRow.createCell(5);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_regist());
                //车辆表总里程
                hssfCell1=hssfRow.createCell(6);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_mile());
                //车辆变速箱
                hssfCell1=hssfRow.createCell(7);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_at());
                //车辆排量
                hssfCell1=hssfRow.createCell(8);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_dc());
                //车辆新车价格
                hssfCell1=hssfRow.createCell(9);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_newprice());
                //车辆过户次数
                hssfCell1=hssfRow.createCell(10);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_transfer());
                //车辆总功率
                hssfCell1=hssfRow.createCell(11);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_power());
                //车辆地址
                hssfCell1=hssfRow.createCell(12);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_adress());
                //车辆续航里程
                hssfCell1=hssfRow.createCell(13);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_endurance());
                //车辆电池容量
                hssfCell1=hssfRow.createCell(14);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_capacity());
                //车辆颜色
                hssfCell1=hssfRow.createCell(15);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_dept());
                //车辆生产时间
                hssfCell1=hssfRow.createCell(16);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_producetime());
                //车辆状态
                hssfCell1=hssfRow.createCell(17);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_status());
                //上架时间
                hssfCell1=hssfRow.createCell(18);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_time());
                //车辆钥匙数
                hssfCell1=hssfRow.createCell(19);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(cardto.getCar_keynum());
                valueStatrRow++;



            }

        }
        return hssfWorkbook;
    }
}
