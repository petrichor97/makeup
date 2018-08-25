package com.tianxuan.makeup.service.impl;


import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.tianxuan.makeup.dto.OrderDTO;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import com.tianxuan.makeup.service.OrderService;
import com.tianxuan.makeup.service.PayService;
import com.tianxuan.makeup.utils.JsonUtil;
import com.tianxuan.makeup.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述: 支付实现
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/7 0007 13:52
 */
@Slf4j
@Service
public class PayServiceImpl implements PayService {

    private static final String WECHAT_ORRDER_NAME = "微信天暄美妆订单";

    @Autowired
    private BestPayServiceImpl bestPayService;
    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        // 构造发起支付参数
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderName(WECHAT_ORRDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付，request={}", JsonUtil.toJson(payRequest));
        // 发起支付
        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付，response={}", JsonUtil.toJson(payResponse));

        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        /**
         * 异步通知注意问题：
         * 1. 验证签名（别人模拟请求向该方法发送请求）
         * 2. 支付状态（异步通知结果不一定百分百是支付成功)
         * 3. 支付金额（由于程序或其他原因，订单金额和支付金额不一致）
         * 4. 支付人（下单人 == 支付人），具体看业务需求（代付不要求下单人==支付人）
         */

        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}", payResponse);

        // 收到异步通知后，修改订单支付状态
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        // 1. 判断订单是否存在
        if (orderDTO == null) {
            log.error("【微信支付】异步通知，订单不存在，orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        // 2. 判断金额是否一致(0.10 , 0.1) ==> 规定：两个数相减，当小于某个精度时，认定相等
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单金额与支付金额不一致，orderId={}，微信通知金额={},订单金额={}",
                    payResponse.getOrderId(),
                    payResponse.getOrderAmount(),
                    orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        orderService.paid(orderDTO);
        return payResponse;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信退款】request={}", JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("【微信退款】response={}", JsonUtil.toJson(refundResponse));

        return refundResponse;
    }
}
