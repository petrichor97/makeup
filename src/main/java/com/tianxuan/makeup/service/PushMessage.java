package com.tianxuan.makeup.service;

import com.tianxuan.makeup.dto.OrderDTO;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-21 11:42
 **/
public interface PushMessage {
    /**
     * 订单状态变更消息
     */
    void orderStatus(OrderDTO orderDTO);
}
