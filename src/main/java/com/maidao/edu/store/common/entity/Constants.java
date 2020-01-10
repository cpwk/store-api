package com.maidao.edu.store.common.entity;

public class Constants {

    public static int PAGESIZE_MIN = 10;
    public static int PAGESIZE_MED = 20;
    public static int PAGESIZE_MAX = 50;
    public static int PAGESIZE_INF = 10000;

    public static int SESSION_EXPIRE_DAYS = 2;

    public static final int STATUS_OK = 1;// 默认
    public static final int STATUS_HALT = 2;// 删除、停用、取消

    // 权限操作级别
    public static String LEVEL_PRIMARY = "blue";
    public static String LEVEL_IMPORTANT = "red";
    public static String LEVEL_WARNING = "orange";


}
