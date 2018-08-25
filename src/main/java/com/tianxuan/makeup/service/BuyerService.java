package com.tianxuan.makeup.service;


import com.tianxuan.makeup.dto.OrderDTO;

/**
 * 功能描述: 买家
 * <p>
 * 作者: Petrichor
 * 日期: 2018/8/16
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancleOrder(String openid, String orderId);
}
