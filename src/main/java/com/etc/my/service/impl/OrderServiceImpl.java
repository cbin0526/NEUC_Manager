package com.etc.my.service.impl;

import com.etc.my.dao.OrderDao;
import com.etc.my.dto.CarDto;
import com.etc.my.dto.CountDto;
import com.etc.my.dto.OrderDto;
import com.etc.my.entity.Order;
import com.etc.my.service.OrderService;
import com.etc.my.vo.CarBrandnumVo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;

    public OrderDao getDao() {
        return dao;
    }

    public void setDao(OrderDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Order> getOrder(OrderDto order) {
        return dao.queryOrder(order);
    }

    @Override
    public CountDto getOrderCunt(OrderDto order) {
        return dao.queryOrderCount(order);
    }

    @Override
    public HSSFWorkbook exportExcel(Map<String, Object> map) {
        List<OrderDto> list = dao.queryAllOrder(map);
        if(list ==null){
            return null;
        }
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建一个excel的sheet
        HSSFSheet sheet = hssfWorkbook.createSheet("ordersheet");
        //表头属性名
        String[] propertyName = {"订单编号","订单生成时间", "交易车辆", "下单用户", "订单状态", "订单交易金额",};
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
        hssfCell.setCellValue("订单列表信息");

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
            for (OrderDto orderDto:list) {
                hssfRow=sheet.createRow(valueStatrRow);
                //订单编号
                hssfCell1=hssfRow.createCell(0);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(orderDto.getOrder_code());
                //订单生成时间
                hssfCell1=hssfRow.createCell(1);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(orderDto.getOrder_datetime());
                //车辆品牌
                hssfCell1=hssfRow.createCell(2);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(orderDto.getCar_name());
                //下单用户
                hssfCell1=hssfRow.createCell(3);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(orderDto.getUser_name());
                //订单状态
                hssfCell1=hssfRow.createCell(4);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(orderDto.getOrder_status());
                //订单交易金额
                hssfCell1=hssfRow.createCell(5);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(orderDto.getOrder_price());
                valueStatrRow++;

            }

        }
        return hssfWorkbook;
    }

    public List<CarBrandnumVo> seletCarBrandAndNumByOrderTime(String car_datatime){
        if(car_datatime == null){
            car_datatime = "";
        }
        car_datatime = "%"+car_datatime+"%";
        List<CarBrandnumVo> carBrandnumVos = dao.seletCarBrandAndNumByOrderTime(car_datatime);
        return carBrandnumVos;
    }
}
