package com.tianxuan.makeup.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tianxuan.makeup.dataobject.OrderDetail;
import com.tianxuan.makeup.enums.OrderStatusEnum;
import com.tianxuan.makeup.enums.PayStatusEnum;
import com.tianxuan.makeup.utils.EnumUtil;
import com.tianxuan.makeup.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 功能描述: 订单（数据传输对象）
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/4 0004 14:52
 */
@Data
public class OrderDTO {

    /** 订单id */
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，0：新下单（默认）1：已完成 2：取消 */
    private Integer orderStatus;

    /** 支付状态，0：未支付（默认）1：已支付 */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    // 订单详情列表
    private List<OrderDetail> orderDetailList;

    private Integer currentPage;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }



}
