package com.tianxuan.makeup.controller;

import com.lly835.bestpay.model.PayResponse;
import com.tianxuan.makeup.dto.OrderDTO;
import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import com.tianxuan.makeup.pojo.Message;
import com.tianxuan.makeup.service.OrderService;
import com.tianxuan.makeup.service.PayService;
import com.tianxuan.makeup.service.TxVipUserService;
import com.tianxuan.makeup.utils.CookieUtil;
import com.tianxuan.makeup.utils.MathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-17 16:06
 **/
@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;
    @Autowired
    private TxVipUserService txVipUserService;



    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        // 1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            log.error("【微信支付】发起支付，订单不存在，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        // 2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create");
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
       payService.notify(notifyData);

        // 返回给微信处理结果
        return new ModelAndView("pay/success");
    }

    @GetMapping("/paymoney")
    public String createcharge(@RequestParam("orderId") String orderId,
                               Model model){
        // 1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            log.error("【钱包支付】发起支付，订单不存在，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        model.addAttribute("orderId", orderId);
        model.addAttribute("money", orderDTO.getOrderAmount());
        //2.进入钱包支付页面
        return "chargepay/passwordRight";
    }


    @PostMapping("/chargepay")
    @ResponseBody
    @Transactional
    public Message chargePay(@RequestBody HashMap<String, String> hashMap) {
        String orderId = hashMap.get("orderId");
        String password = hashMap.get("password");
        Message message = new Message();
            OrderDTO orderDTO = orderService.findOne(orderId);
            TxVipUser txVipUser = txVipUserService.getUserInfo(orderDTO.getBuyerOpenid());

            if (!password.equals(txVipUser.getPassword())) {
                message.setMessage("密码错误");
                return message;
            } else {
                //判断余额是否充足
                if (MathUtil.bigger(txVipUser.getMoney(),orderDTO.getOrderAmount())) {
                    //修改会员状态，余额
                    txVipUser.setMoney(MathUtil.subtraction(txVipUser.getMoney(), orderDTO.getOrderAmount()));
                    txVipUserService.flushmoney(txVipUser);
                    //修改订单状态
                    orderService.paid(orderDTO);
                } else {
                    log.error("【钱包支付】发起支付，余额不足，orderId={}", orderId);
                    throw new SellException(ResultEnum.MONEY_ERROR);
                }
                message.setMessage("密码正确");
                return message;
            }
        }


    }



