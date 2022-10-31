package com.etc.my.controller;


import com.etc.my.dto.MyMessage;
import com.etc.my.entity.User;
import com.etc.my.service.UserService;
import com.etc.my.util.IsFish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    public UserService getUs() {
        return us;
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public MyMessage getAllUser(){
        MyMessage message = new MyMessage();
        List<User> list = us.getAllUser();

        message.setData(list);
        return message;
    }
    //管理员登录
    @RequestMapping("/checkLogin")
    public void checkLogin(String user_name,String user_pwd,HttpServletResponse response, HttpServletRequest request)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        IsFish isFish=new IsFish();
        if(isFish.isFish(request)){
            User user=us.checkLogin(user_name,user_pwd);


            if(user!=null&&"admin".equals(user_name)&&"123".equals(user_pwd)){
                request.getSession().setAttribute("loginuser",user);
                out.print("<script>alert('登录成功');location.href='index.jsp'</script>");

            }else{
                out.print("<script>alert('登录失败');history.go(-1);</script>");

            }
            out.flush();
            out.close();
        }else{
            out.print("<script>alert('滚吧，盗链狗！！！！');history.go(-1);</script>");
        }
        out.flush();
        out.close();


    }
    //注销
    @RequestMapping("/loginout")
    public  void loginout(HttpServletResponse response,HttpServletRequest request)throws Exception{
        HttpSession session=request.getSession();
        User user= (User) request.getSession().getAttribute("loginuser");
        session.invalidate();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print("<script>alert('会话已失效，请重新登录');location.href='login.jsp'</script>");



    }



}
