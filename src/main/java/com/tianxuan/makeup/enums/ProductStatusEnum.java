package com.tianxuan.makeup.enums;

import lombok.Getter;

/**
 * 功能描述: 商品状态
 * <p>
 * 作者: luohq
 * 日期: 2018/3/11 20:25
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
