package com.etc.my.controller;


import com.etc.my.dto.CountDto;
import com.etc.my.dto.MyMessage;
import com.etc.my.dto.PageDto;
import com.etc.my.dto.PushDto;
import com.etc.my.entity.Car;
import com.etc.my.entity.Push;
import com.etc.my.service.CarService;
import com.etc.my.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class PushController {


    @Autowired
   private PushService pushs;
    public PushService getPushs() {
        return pushs;
    }

    public void setPushs(PushService pushs) {
        this.pushs = pushs;
    }

    @Autowired
    private CarService carService;


    @RequestMapping("/selectAllPush")
    @ResponseBody
    public MyMessage selectAllPush(HttpServletRequest request){
        //设置初始值
        int page = 1;
        int size = 5;
        //获取前端值
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        try{
            page = Integer.parseInt(pageStr);
            size = Integer.parseInt(sizeStr);
        }catch (Exception e){
            page = 1;
            size = 5;
            System.out.println(e.toString());
        }
        //最大页数
        CountDto countDto = pushs.countAllPush();
        Integer allCount = countDto.getAllCount();
        Integer maxPage = allCount%size==0?allCount/size:allCount/size+1;

        page = page > maxPage?maxPage:page;
        page = page <= 0?1:page;
        size = size <= 0?5:size;
        size = size > allCount?5:size;

        MyMessage message = new MyMessage();

        List<Push> pushes = pushs.selectAllPush(page,size);
        if(pushes != null){
            message.setFlag(200);
            message.setOlist(pushes);
            message.setPage(page);
            message.setSize(size);
            message.setMaxPage(maxPage);
        }
        return message;
    }

    /**
     * 推送车辆
     */
    @RequestMapping("/pushcar")
    public void pushcar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Integer push_id = Integer.valueOf(request.getParameter("push_id"));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //查询这个推送表
        PushDto push = pushs.queryOnePushById(push_id);
        if(push == null){
            writer.print("<script>alert('推送失败，请重试');location.href='pushcar.jsp'</script>");
            writer.flush();
            writer.close();
        }
        String car_brand = push.getPush_brand();
        String car_name = push.getPush_carname();
        String car_dept = push.getPush_dept();
        //查car里面有没有这类型的车
        String car_id = carService.queryCarIdByNameBrandDept(car_name, car_brand, car_dept);
        if(car_id != null){
            //填入carid和修改状态
            boolean b = pushs.updatePushStatueAndCarid(car_id, push_id);
            if(b){
                //修改成功
                writer.print("<script>alert('推送成功');location.href='pushcar.jsp'</script>");
                writer.flush();
                writer.close();
            }else{
                //失败
                writer.print("<script>alert('推送失败');location.href='pushcar.jsp'</script>");
                writer.flush();
                writer.close();
            }
        }else{
            //失败
            writer.print("<script>alert('没有类似车型');location.href='pushcar.jsp'</script>");
            writer.flush();
            writer.close();
        }

    }
}
