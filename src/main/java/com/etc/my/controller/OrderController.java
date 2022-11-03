package com.etc.my.controller;


import com.etc.my.service.OrderService;
import com.etc.my.vo.CarBrandnumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
