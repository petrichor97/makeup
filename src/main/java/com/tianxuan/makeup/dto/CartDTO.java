package com.tianxuan.makeup.dto;

import lombok.Data;

/**
 * 功能描述: 购物车
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 15:43
 */
@Data
public class CartDTO {

    /** 商品Id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
