package com.etc.my.dto;

import java.util.List;

/**
 * 前后端交互统一的交互对象
 */
public class MyMessage {
    private String code;  //响应编码
    private int flag;   // 根据标杆结果进行相应判断
    private Object data;  //前后端交互的数据
    private String info;//前后端交互的字符串提示
    private Integer page;
    private Integer size;
    private String key = "";
   private Integer maxPage;
   private Object olist;

    public Object getOlist() {
        return olist;
    }

    public void setOlist(Object olist) {
        this.olist = olist;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
