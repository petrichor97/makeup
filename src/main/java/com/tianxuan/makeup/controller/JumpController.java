package com.tianxuan.makeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/userRegisterJump")
    public String userRegisterJump(String openid,Model model) {
        model.addAttribute("openid", openid);
        return "userRegister";
    }

    @RequestMapping("/registerSuccessJump")
    public String registerSuccessJump() { return "registerSuccess"; }

    @RequestMapping("/vipCardJump")
    public String vipCardJump() { return "vipCard"; }

    @RequestMapping("/myWalletJump")
    public String myWalletJump() { return "myWallet"; }

    @RequestMapping("/userInfoJump")
    public String userInfoJump() { return "userInfo"; }

    @RequestMapping("/billJump")
    public String billJump() { return "bill"; }

    @RequestMapping("/birthdayPrivilegesJump")
    public String birthdayPrivilegesJump() { return "birthdayPrivileges"; }

    @RequestMapping("/activityJump")
    public String activityJump() { return "activity"; }

    @RequestMapping("/payMoneySuccessJump")
    public String payMoneySuccessJump() { return "payMoneySuccess"; }

}
