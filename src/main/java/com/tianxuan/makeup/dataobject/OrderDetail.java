package com.tianxuan.makeup.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @program: makeup
 * @description: 订单详情表
 * @author: Petrichor
 * @create: 2018-08-16 09:47
 **/
@Data
@Entity
public class OrderDetail {

    /** 订单详情ID */
    @Id
    private String detailId;

    /** 订单id */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品小图 */
    private String productIcon;

}
