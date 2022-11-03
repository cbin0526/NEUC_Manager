package com.etc.my.controller;

import com.etc.my.dto.*;
import com.etc.my.service.ReserveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ReserveController {
    @Autowired
    private ReserveService rs;

    public ReserveService getRs() {
        return rs;
    }

    public void setRs(ReserveService rs) {
        this.rs = rs;
    }

    /*
    利用ajax获取预约信息和动态查询
     */
    @RequestMapping("/getReserve")
    @ResponseBody
    public MyMessage getReserve(ReserveDto reserveDto) {


        MyMessage myMessage = new MyMessage();
        //page，size默认值
        Integer page = reserveDto.getPage();
        Integer size = reserveDto.getSize();
        //注入值
        reserveDto.setUser_name("%" + reserveDto.getUser_name() + "%");
        reserveDto.setReserve_phone("%" + reserveDto.getReserve_phone() + "%");
        reserveDto.setReserve_date("%" + reserveDto.getReserve_date() + "%");
        reserveDto.setCar_name("%" + reserveDto.getCar_name() + "%");
        reserveDto.setReserv_status("%" + reserveDto.getReserv_status() + "%");
        //page，size默认值

        //size.page.maxPage容错
        size = size <= 0 ? 5 : size;
        page = page <= 0 ? 1 : page;
        Long count = rs.getReserveCount();
        Integer maxPage = (int) (count % size == 0 ? (count / size) : (count / size + 1));
        page = page > maxPage ? maxPage : page;
        reserveDto.setSize(size);
        reserveDto.setPage((page - 1) * size);
        reserveDto.setMaxPage(maxPage);
        List<ReserveDto> list = rs.getAllReserve(reserveDto);
        myMessage.setData(reserveDto);
        myMessage.setOlist(list);
        myMessage.setPage(page);
        myMessage.setSize(size);
        myMessage.setMaxPage(maxPage);

        return myMessage;

    }

    //根据id查询预约信息
    @RequestMapping("/getReserveById")
    public void getReserveById(HttpServletRequest request, HttpServletResponse response,Integer rid) throws Exception {
        ReserveDto reserveDto = rs.getReserve(rid);
        request.setAttribute("ReserveDto", reserveDto);
        request.getSession().setAttribute("ReserveDto", reserveDto);
        request.getRequestDispatcher("editReserve.jsp").forward(request, response);

    }

    //修改预约信息
    @RequestMapping(value = "/updateReserve",produces = {"text/html;charset=utf-8"})
    public void updateReserve(ReserveDto reserveDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        try {
            if (rs.updateReserve(reserveDto)) {
                out.print("<script>alert('修改成功');location.href='lookcarreserve.jsp';</script>");
            } else {
                out.print("<script>alert('修改失败');history.go(-1);</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('修改失败');history.go(-1);</script>");
        }


    }
}
