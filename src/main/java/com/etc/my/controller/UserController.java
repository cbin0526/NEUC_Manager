package com.etc.my.controller;


import com.etc.my.dto.MyMessage;
import com.etc.my.dto.PageDto;
import com.etc.my.dto.UserDto;
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

    @RequestMapping("/changeUserStatus")
    @ResponseBody
    public MyMessage changeUserStatus(Integer user_id,String user_status){
        MyMessage message = new MyMessage();
        if(user_id==null || user_status==null || user_id<0){
            message.setFlag(0);
            message.setInfo("传入的参数有误，请稍后再试...");
        }else{
            if(us.changeUserStatus(user_id,user_status)){
                message.setFlag(1);
            }else{
                message.setFlag(0);
                message.setInfo(user_status+"状态修改异常，请稍后再试...");
            }
        }
        return message;
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public MyMessage selectUser(UserDto user){
        MyMessage message = new MyMessage();
        //page，size默认值
        Integer page = user.getPage();
        Integer size = user.getSize();
        //对分页数据进行容错
        if (page == null || page <= 0) {
            page = 1;
        }

        if (size == null || size <= 0) {
            size = 5;
        }
        //注入值
        if(user.getUser_name()!=null || ("".equals(user.getUser_name()))){
            user.setUser_name("%"+user.getUser_name()+"%");
        }
       if(user.getUser_phone()!=null || !("".equals(user.getUser_phone()))){
           user.setUser_phone("%"+user.getUser_phone()+"%");
       }
       if(user.getUser_idcard()!=null || !("".equals(user.getUser_idcard()))){
            user.setUser_idcard("%"+user.getUser_idcard()+"%");
        }
       if(user.getUser_status()!=null || !("".equals(user.getUser_status()))){
           user.setUser_status("%"+user.getUser_status()+"%");
       }
       // List<User> list=us.queryUserByCondition(user);
        user.setSize(size);
        user.setPage((page - 1) * size);

        Integer count = us.getUserCountWithCondition(user).getAllCount();
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
            List<User> list = us.queryUserByCondition(user);
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



}
