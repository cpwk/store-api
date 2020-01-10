package com.maidao.edu.store.common.entity;

public enum ErrorCode {
    // common
    DETAILED(600, ""),
    UNKNOWN(601, "操作失败"),
    UNREACHED(602, "不可操作"),
    SESSIONTIMEOUT(603, "登录超时"),
    NO_PERMISSION(604, "没有权限"),

    //common
    ERROR_MOBILE(610, "手机号码格式错误"),


    // admin
    NOUSER(620, "未知用户"),
    ERROR_PWD(621, "密码错误"),
    LOGIN_STATUS(622, "账号异常");

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
