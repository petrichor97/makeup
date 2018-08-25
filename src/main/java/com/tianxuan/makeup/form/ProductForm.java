package com.tianxuan.makeup.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 功能描述: 商品表单验证
 * <p>
 * 作者: Petrichor
 * 日期: 2018/5/8 0008 10:21
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
