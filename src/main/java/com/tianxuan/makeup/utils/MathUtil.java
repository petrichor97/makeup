package com.tianxuan.makeup.utils;

import java.math.BigDecimal;

/**
 * 功能描述: 数学工具类
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/7 0007 16:05
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 功能描述: 比较两个金额是否相等（相减绝对值小于0.01认定相等）
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 16:05
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能描述: 比较金额前者是否大于后者
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 16:05
     */
    public static Boolean bigger(BigDecimal b1, BigDecimal b2) {
        int compare = b1.subtract(b2).compareTo(new BigDecimal(0));
        if (compare != -1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 功能描述: 金额相减
     *      * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 16:05
     */
    public static BigDecimal subtraction(BigDecimal d1, BigDecimal d2) {
        return d1.subtract(d2);
    }

}
