package com.etc.my.controller;


import com.etc.my.dto.MyMessage;
import com.etc.my.dto.PageDto;
import com.etc.my.dto.SellOfKeysDto;
import com.etc.my.entity.Sell;
import com.etc.my.entity.User;
import com.etc.my.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class SellController {
    @Autowired
    private SellService ss;

    public SellService getSs() {
        return ss;
    }

    public void setSs(SellService ss) {
        this.ss = ss;
    }


    @RequestMapping("/getSellByKeys")
    @ResponseBody
    public MyMessage getSellByKeys(SellOfKeysDto sokd){
        MyMessage message = new MyMessage();

            Integer page=1;
            Integer size=3;
            //判断是否有取到值
            if(sokd.getPage()!=null||sokd.getPage()>0){
                page=sokd.getPage();
            }

            if(sokd.getSize()!=null||sokd.getSize()>0){
                size=sokd.getSize();
            }
            //获取总条数
            Integer allCount = ss.getSellCount(sokd).getAllCount();
            if(allCount>=0&&allCount!=null){
                Integer maxPage = (allCount%size==0)?(allCount/size):(allCount/size+1);
                //页数条数上限容错
                page=page>maxPage?maxPage:page;
                size=size>3?3:size;
                //页数条数下限容错
                page=page<=0?1:page;
                size=size<=0?3:size;

                PageDto pd = new PageDto();
                pd.setPage(page);
                pd.setSize(size);

                sokd.setPage((page-1)*size);
                sokd.setSize(size);

                sokd.setSell_address("%"+sokd.getSell_address()+"%");
                sokd.setSell_cardept("%"+sokd.getSell_cardept()+"%");
                sokd.setSell_carname("%"+sokd.getSell_carname()+"%");
                sokd.setSell_phone("%"+sokd.getSell_phone()+"%");
                sokd.setSell_status("%"+sokd.getSell_status()+"%");
                //调用方法查询
                List<Sell> pushList = ss.getSellByKeysOfPage(sokd);
                if(pushList.size()>0&&pushList!=null){
                    message.setFlag(1);
                    pd.setMaxPage(maxPage);
                    pd.setAllCount(allCount);
                    pd.setOlist(pushList);
                    message.setData(pd);
                }else{
                    message.setFlag(0);
                    message.setInfo("查无此纪录");
                }
            }else{
                message.setFlag(0);
                message.setInfo("查无此纪录");
            }

        System.out.println(message);
        return message;
    }

    @RequestMapping("/updateStatusById")
    @ResponseBody
    public void updateStatusById(HttpServletResponse response ,Integer sellid) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(sellid==null||sellid<=0){
            out.print("<script>alert('参数异常请重试！');history.go(-1)</script>");
        }else{
            boolean flag=ss.updateStatusById(sellid);
            if(flag){
                out.print("<script>alert('沟通成功！');location.href='sellcarreserve.jsp'</script>");
            }else{
                out.print("<script>alert('沟通失败！');history.go(-1)</script>");
            }
        }

        out.flush();
        out.close();
    }
}

