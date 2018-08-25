package com.tianxuan.makeup.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 功能描述: JSON格式化工具
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/7 0007 14:28
 */
public class JsonUtil {

    /**
     * 功能描述: 将对象格式化JSON数据
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 14:28
     */
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
