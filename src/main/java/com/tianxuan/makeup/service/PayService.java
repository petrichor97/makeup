package com.tianxuan.makeup.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.tianxuan.makeup.dto.OrderDTO;

/**
 * 功能描述: 支付service
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/7 0007 13:51
 */
public interface PayService {

    /**
     * 功能描述: 生成支付信息
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 13:52
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 功能描述: 微信支付后异步通知
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 15:45
     */
    PayResponse notify(String notifyData);

    /**
     * 功能描述: 微信退款
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 16:19
     */
    RefundResponse refund(OrderDTO orderDTO);
}
