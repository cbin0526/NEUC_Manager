package com.etc.my.controller;


import com.etc.my.dto.MyMessage;
import com.etc.my.dto.OrderDto;
import com.etc.my.dto.PageDto;
import com.etc.my.entity.Order;
import com.etc.my.service.OrderService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.etc.my.vo.CarBrandnumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
   private OrderService os;

    public OrderService getOs() {
        return os;
    }

    public void setOs(OrderService os) {
        this.os = os;
    }

    //查询订单
    @RequestMapping("/allOrder")
    @ResponseBody
    public MyMessage getallOrder(OrderDto order){
       MyMessage  message = new MyMessage();
        //page，size默认值
        Integer page = order.getPage();
        Integer size = order.getSize();
        //对分页数据进行容错
        if (page == null || page <= 0) {
            page = 1;
        }

        if (size == null || size <= 0) {
            size = 5;
        }
        //注入值
       order.setOrder_code(("%" + order.getOrder_code() + "%"));
       order.setOrder_datetime(("%" + order.getOrder_datetime() + "%"));
       order.setCar_name(("%" + order.getCar_name() + "%"));
       order.setUser_name(("%" + order.getUser_name() + "%"));
       order.setOrder_status(("%" + order.getOrder_status() + "%"));
       order.setOrder_price("%" + order.getOrder_price() +  "%" );
       order.setSize(size);
       order.setPage((page - 1) * size);

        Integer count = os.getOrderCunt(order).getAllCount();
        Integer maxPage = (int) (count % size == 0 ? (count / size) : (count / size + 1));
        //页数条数上限容错
        page = page > maxPage ? maxPage : page;
        size = size > 5 ? 5 : size;
        //页数条数下限容错
        page = page <= 0 ? 1 : page;
        size = size <= 0 ? 5 : size;
        page = page > maxPage ? maxPage : page;

        PageDto pd = new PageDto();
        pd.setPage(page);
        pd.setSize(size);
        pd.setMaxPage(maxPage);

        try{
            List<Order> list = os.getOrder(order);
            if (list == null || list.size() == 0) {
                message.setFlag(0);
                message.setInfo("没有相应数据");
            } else {
                pd.setAllCount(count);
                pd.setOlist(list);
                message.setCode("200");
                message.setFlag(1);
                message.setInfo("有相应数据");
                //把pageDto放入消息类返回给前端
                message.setData(pd);
            }
        }catch (Exception e){
            message.setCode("500");
            message.setInfo("服务器内部异常！！！！");
        }
        return message;
    }

    //导出excel文件
    @RequestMapping("/exportOrderExcel")
    @ResponseBody
    public String exportExcel(HttpServletResponse response, Map<String, Object> params) {

        HSSFWorkbook workbook = os.exportExcel(params);
        try {
            if (response != null) {
                response.setContentType("application/vnd.ms-excel;charset=utf-8");
                response.setHeader("Content-Disposition",
                        "attachment;filename=\"" + new String(("订单数据信息表" + ".xls").getBytes("gb2312"), "ISO8859-1"));
                OutputStream out = response.getOutputStream();
                workbook.write(out);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @RequestMapping("/orderTimeAndBrand")
    @ResponseBody
    public List<CarBrandnumVo> orderTimeAndBrand(HttpServletRequest request){
        String order_datetime = request.getParameter("mouth");
        if(order_datetime == null || order_datetime == ""){
            order_datetime = new SimpleDateFormat("yyyy-MM").format(new Date());
        }

        return os.seletCarBrandAndNumByOrderTime(order_datetime);
    }
}
