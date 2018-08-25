package com.tianxuan.makeup.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import com.tianxuan.makeup.entity.ChargeMoney;
import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.entity.UserWelfare;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import com.tianxuan.makeup.repository.OrderMoneyRepository;
import com.tianxuan.makeup.repository.TxVipUserRepository;
import com.tianxuan.makeup.repository.UserWelfareRepository;
import com.tianxuan.makeup.service.ChargeMoneyService;
import com.tianxuan.makeup.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Slf4j
@Service
public class ChargeMoneyServiceImpl implements ChargeMoneyService {


    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private TxVipUserRepository txVipUserRepository;

    @Autowired
    private OrderMoneyRepository orderMoneyRepository;

    @Autowired
    private UserWelfareRepository userWelfareRepository;

    @Autowired
    private InviteRegisterServiceImpl inviteRegisterService;

    private static final String WECHAT_ORRDER_NAME = "微信天暄美妆氪金";

    @Override
    public PayResponse create(ChargeMoney chargeMoney) {
        // 构造发起支付参数
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(chargeMoney.getOpenid());
        payRequest.setOrderId(chargeMoney.getOrderId());
        payRequest.setOrderAmount(chargeMoney.getMoney().doubleValue());
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

        ChargeMoney chargeMoneyOrder = orderMoneyRepository.findOne(payResponse.getOrderId());

//        修改订单标志位
        if (chargeMoneyOrder.getMaker().equals("0")) {
            chargeMoneyOrder.setMaker("1");
            orderMoneyRepository.saveAndFlush(chargeMoneyOrder);
            //充钱
            chargeMoney(chargeMoneyOrder.getOpenid(), BigDecimal.valueOf(payResponse.getOrderAmount()));
            //        充钱得积分
            chargeMoneyGetIntegral(chargeMoneyOrder.getOpenid(), BigDecimal.valueOf(payResponse.getOrderAmount()));
//被邀请用户首次充值
            inviteRegisterService.inviteRegisterWelfare(chargeMoneyOrder.getOpenid());
        }


        return payResponse;

    }


    //充钱
    @Override
//    @Transactional
    public void chargeMoney(String openid, BigDecimal money) {
        TxVipUser txVipUserMoney = txVipUserRepository.findOne(openid);
        BigDecimal moneyBefor = txVipUserMoney.getMoney();
        BigDecimal after = moneyBefor.add(money);

//充值优惠
        UserWelfare userWelfare = new UserWelfare();
        String key = money.toString();
        switch (key) {
            case "0.01":
                userWelfare.setOpenid(openid);
                userWelfare.setWelfareId(1);
                userWelfareRepository.save(userWelfare);
                break;
            case "0.02":
                userWelfare.setOpenid(openid);
                userWelfare.setWelfareId(2);
                userWelfareRepository.save(userWelfare);
                after = after.add(new BigDecimal(20));
                break;
            case "0.03":
                userWelfare.setOpenid(openid);
                userWelfare.setWelfareId(3);
                userWelfareRepository.save(userWelfare);
                after = after.add(new BigDecimal(40));
                break;
            case "0.04":
                after = after.add(new BigDecimal(70));
                break;
            case "0.05":
                userWelfare.setOpenid(openid);
                userWelfare.setWelfareId(4);
                userWelfareRepository.save(userWelfare);
                break;
            case "0.06":
                after = after.add(new BigDecimal(150));
                break;
            default:
                throw new SellException(ResultEnum.PARAM_ERROR.getCode(), "非法操作");
        }

        txVipUserRepository.modifyMpneyByopenid(after, openid);
    }

    @Override
    public void orderInDatebase(ChargeMoney chargeMoney) {
        orderMoneyRepository.save(chargeMoney);
    }

    // 充钱得积分
    @Override
    public void chargeMoneyGetIntegral(String openid, BigDecimal money) {

        TxVipUser txVipUser = txVipUserRepository.findOne(openid);
        int integralBefore = txVipUser.getIntegral();
        BigDecimal divide = money.divide(BigDecimal.valueOf(10));
        int divideInt = divide.intValue();
        int integralAfter = integralBefore + divideInt;
        txVipUser.setIntegral(integralAfter);
        txVipUserRepository.saveAndFlush(txVipUser);


    }

}
