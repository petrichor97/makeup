package com.tianxuan.makeup.service;

import com.lly835.bestpay.model.PayResponse;
import com.tianxuan.makeup.entity.ChargeMoney;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface ChargeMoneyService {


//      功能描述: 生成支付信息

    PayResponse create(ChargeMoney chargeMoney);


//      微信支付后异步通知

    PayResponse notify(String notifyData);

//    给用户充钱
//@Transactional
    void chargeMoney(String openid, BigDecimal money);

    //订单入数据库
    void orderInDatebase(ChargeMoney chargeMoney);

    void chargeMoneyGetIntegral(String openid,BigDecimal money);
}
