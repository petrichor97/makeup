package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.pojo.Message;
import com.tianxuan.makeup.service.IntegralService;
import com.tianxuan.makeup.service.TxVipUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class integralController {

@Autowired
private TxVipUserService txVipUserService;

@Autowired
private IntegralService integralService;

    @RequestMapping("/integralShop")
    public String integralShopJump(String openid, Model model) {
        TxVipUser userInfo = txVipUserService.getUserInfo(openid);
        if (userInfo == null) {
            return "userNoRegister";
        }
        int integral = userInfo.getIntegral();
        model.addAttribute("openid", openid);
        model.addAttribute("integral",integral);
        return "integralShop";
    }


    @RequestMapping("/countDown")
    public String countDown(String openid,String goods, int num,Model model) {
        Message message = integralService.saveUserIntegral(openid, num);
        if (message.getMessage().equals("积分不足")){
            model.addAttribute("message", message.getMessage());
            return "errorMessage";
        }

        model.addAttribute("message", message.getMessage());
        model.addAttribute("goods", goods);
        return "countDown";
    }
}
