package com.etc.my.dto;

/**
 * 前后端交互统一的交互对象
 */
public class MyMessage {
    private String code;  //响应编码
    private int flag;   // 根据标杆结果进行相应判断
    private Object data;  //前后端交互的数据
    private String info;  //前后端交互的字符串提示

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
