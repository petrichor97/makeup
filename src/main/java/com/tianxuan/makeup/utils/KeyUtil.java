package com.tianxuan.makeup.utils;

import java.util.Random;

/**
 * 功能描述: 生成随机数工具
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 15:13
 */
public class KeyUtil {

    /**
     * 功能描述: 生成唯一的主键（格式：时间 + 6位随机数）
     * synchronized：在多线程下保证唯一性
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/4 0004 15:16
     * @param: []
     * @return: java.lang.String
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000; // 生成6位数

        return System.currentTimeMillis() + String.valueOf(number);
    }


    public static synchronized String productKey() {
        Random random = new Random();
        Integer number = random.nextInt() + 1; // 生成6位数
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
