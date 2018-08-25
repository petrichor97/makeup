package com.tianxuan.makeup.enums;

import lombok.Getter;

/**
 * 功能描述: 订单状态枚举
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 11:47
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
