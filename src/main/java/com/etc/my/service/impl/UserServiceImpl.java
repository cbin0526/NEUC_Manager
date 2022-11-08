package com.etc.my.service.impl;

import com.etc.my.dao.UserDao;
import com.etc.my.dto.CountDto;
import com.etc.my.dto.UserDto;
import com.etc.my.entity.User;
import com.etc.my.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }



    @Override
    public List<User> getAllUser() {
        return dao.queryAllUser();
    }

    @Override
    public User getUser(String user_phone) {
        if(user_phone==null){
            return null;
        }else{
            return dao.queryUser(user_phone);
        }

    }


    @Override
    public User checkLogin(String user_name, String user_pwd) {
        if(user_name==null&&user_pwd==null){
            return null;
        }
        return dao.check(user_name,user_pwd);
    }

    @Override
    public boolean changeUserStatus(Integer user_id, String user_status) {
        if(user_id==null || user_id<0 || user_status==null){
            System.out.println("user_id 或者user_status参数有误");
            return false;
        }else{
            return dao.updateUserStatus(user_id,user_status);
        }
    }

    @Override
    public List<User> queryUserByCondition(UserDto user) {
        return dao.queryUserByCondition(user);
    }

    @Override
    public CountDto getUserCountWithCondition(UserDto user) {
       return dao.getUserCount(user);
    }

    @Override
    public HSSFWorkbook exportExcel(Map<String, Object> map) {
        List<User> list = dao.queryAllUser(map);
        if(list ==null){
            return null;
        }
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建一个excel的sheet
        HSSFSheet sheet = hssfWorkbook.createSheet("usersheet");
        //表头属性名
        String[] propertyName = {"用户编号","用户账号", "用户姓名", "身份证号", "账户状态"};
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
            for (User user:list) {
                hssfRow=sheet.createRow(valueStatrRow);
                //用户编号
                hssfCell1=hssfRow.createCell(0);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(user.getUser_id());
                //用户账号
                hssfCell1=hssfRow.createCell(1);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(user.getUser_phone());
                //用户姓名
                hssfCell1=hssfRow.createCell(2);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(user.getUser_name());
                //用户身份证
                hssfCell1=hssfRow.createCell(3);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(user.getUser_idcard());
                //账号状态
                hssfCell1=hssfRow.createCell(4);
                hssfCell.setCellStyle(hssfCellStyle2);
                hssfCell1.setCellValue(user.getUser_status());

            }

        }
        return hssfWorkbook;
    }
}
