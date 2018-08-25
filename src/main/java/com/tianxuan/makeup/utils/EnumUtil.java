package com.tianxuan.makeup.utils;


import com.tianxuan.makeup.enums.CodeEnum;

/**
 * 功能描述: 枚举工具类
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/8 0008 9:20
 */
public class EnumUtil {

    /**
     * 根据code和枚举类返回响应的枚举
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
