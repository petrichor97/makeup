package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.service.TxVipUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vipCardController {

    @Autowired
    private TxVipUserService txVipUserService;

    //会员页面数据查询
    @RequestMapping("/vipCard")
    public String findUserInVipCard(String openid,Model model) {
        TxVipUser txVipUser = txVipUserService.getUserInfo(openid);
        if (txVipUser == null) {
            return "userNoRegister";
        }
        model.addAttribute("txVipUser", txVipUser);
        return "vipCard";


    }
}
