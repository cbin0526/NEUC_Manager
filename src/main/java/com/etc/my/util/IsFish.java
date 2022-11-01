package com.etc.my.util;

import javax.servlet.http.HttpServletRequest;

public class IsFish {
    /**
     * 判断是否被盗链
     *
     * @param request
     * @return
     */
    public boolean isFish(HttpServletRequest request) {
        //获取网站的root
        //获取当前项目名
        String path = request.getContextPath();
        //获取动态路径 http://ip:port/项目名/
        String bathPath = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort()+path+"/";
        System.out.println("当前项目的网络地址:"+bathPath);
        //获取上个页面的地址
        String url = request.getHeader("referer");
        System.out.println("上一个页面的地址是"+url);
        return url != null && url.startsWith(bathPath);

    }
}
