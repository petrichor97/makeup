package com.tianxuan.makeup.enums;

import lombok.Getter;

/**
 * 功能描述: 支付状态枚举
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 11:51
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
