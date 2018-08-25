//package com.tianxuan.makeup.controller;
//
//import com.lly835.bestpay.model.PayResponse;
//import com.sun.org.apache.xpath.internal.operations.Mod;
//import com.tianxuan.makeup.entity.ChargeMoney;
//import com.tianxuan.makeup.service.ChargeMoneyService;
//import com.tianxuan.makeup.utils.KeyUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.xml.crypto.Data;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//@Controller
//@RequestMapping("/pay")
//public class ChargeMoneyController {
//
//    @Autowired
//    private ChargeMoneyService chargeMoneyService;
//
//    @GetMapping("/create")
//    public ModelAndView create(ChargeMoney chargeMoney,
//                               @RequestParam("returnUrl") String returnUrl,
//                               Map<String, Object> map) {
//
//        // 2. 发起支付
//        PayResponse payResponse = chargeMoneyService.create(chargeMoney);
//       SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //把时间转换为指定字符串格式
//        String time = simpledateformat.format(new Date());
//
//        chargeMoney.setChargeTime(time);
////        订单标准位，0为付款，1已付款
//        chargeMoney.setMaker("0");
////        订单入数据库
//        chargeMoneyService.orderInDatebase(chargeMoney);
//        map.put("payResponse", payResponse);
//        map.put("returnUrl", returnUrl);
//        return new ModelAndView("pay/create");
//    }
//
//    @PostMapping("/notify")
//    public ModelAndView notify(@RequestBody String notifyData) {
//        PayResponse notify = chargeMoneyService.notify(notifyData);
//
//        // 返回给微信处理结果
//        return new ModelAndView("pay/success");
//    }
//
//
//    @RequestMapping("/createMoneyOrder")
//    public String createMoneyOrder( BigDecimal money) {
//
//        String orderId = KeyUtil.genUniqueKey();
//
//        return "/pay/create?orderId="+orderId+"&money="+money+"&returnUrl=/sell/wechat/authorize?returnUrl=/myWallet";
//    }
//}
