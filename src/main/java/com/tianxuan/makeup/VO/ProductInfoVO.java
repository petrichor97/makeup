package com.tianxuan.makeup.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 功能描述: 商品详情
 * <p>
 * 作者: luohq
 * 日期: 2018/3/13 20:29
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -5390067682058449336L;

    @JsonProperty("id")
    private String productId;

    /** 名字 */
    @JsonProperty("name")
    private String productName;

    /** 单价 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 小图 */
    @JsonProperty("icon")
    private String productIcon;

}
