package com.tianxuan.makeup.controller;


import com.tianxuan.makeup.entity.TxVipUser;
import com.tianxuan.makeup.pojo.Message;
import com.tianxuan.makeup.service.InviteRegisterService;
import com.tianxuan.makeup.service.TxVipUserService;
import com.tianxuan.makeup.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private TxVipUserService txVipUserService;

    @Autowired
    private InviteRegisterService inviteRegisterService;

    @RequestMapping("/userRegister")
    @ResponseBody
    public Message userRegister(@RequestBody TxVipUser txVipUser) {
        String openid = txVipUser.getOpenid();
        String name = txVipUser.getName();
        String school = txVipUser.getSchool();
        String institute = txVipUser.getInstitute();
        String password = txVipUser.getPassword();

        Message message = new Message();

//        校验用户输入合法性
        if (!Validator.nameValidator(name)) {
            message.setMessage("输入3-8个汉字");
            return message;
        } else if (!Validator.chineseValidator(school)) {
            message.setMessage("学校不合法");
            return message;
        } else if (!Validator.chineseValidator(institute)) {
            message.setMessage("学院不合法");
            return message;
        } else if (!Validator.idPasswordValidator(password)) {
            message.setMessage("密码不合法");
            return message;
        }

//        校验openid是否注册
        Long openidIsRegist = txVipUserService.countByOpenid(openid);


//        校验昵称是否注册
        Long nameIsRegist = txVipUserService.countByName(name);

        if (openidIsRegist > 0) {
            message.setMessage("微信号已注册");
            return message;
        } else if (nameIsRegist > 0) {
            message.setMessage("昵称已注册");
            return message;
        } else {

            if (txVipUser.getBeInvitationCode() != null&&txVipUser.getBeInvitationCode() !="") {
                if (txVipUserService.countInviteCode(txVipUser.getBeInvitationCode()) <=0) {
                    message.setMessage("邀请码错误");
                    return message;
                }
//                关联邀请用户和被邀请用户
                inviteRegisterService.saveInviteRegisterTable(txVipUser);
            }
            txVipUserService.userRegister(txVipUser);
            message.setMessage("注册成功");
            return message;
        }


    }


    //    获取用户信息
    @RequestMapping("/getUserInfo")
    public String getUserInfo(String openid, Model model) {

        TxVipUser txVipUser = txVipUserService.getUserInfo(openid);
        Date birthday = txVipUser.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthdatSimple = simpleDateFormat.format(birthday);
        model.addAttribute("birthdatSimple", birthdatSimple);
        model.addAttribute("txVipUser", txVipUser);
        return "userInfo";

    }


    //    余额查询
    @RequestMapping("/myWallet")
    public String findMoneyByopenid(String openid, Model model) {

        TxVipUser txVipUser = txVipUserService.getUserInfo(openid);
        if (txVipUser == null) {
            return "userNoRegister";
        }
        BigDecimal money = txVipUser.getMoney();
        model.addAttribute("money", money);
        model.addAttribute("openid", openid);

        return "myWallet";
    }


    //    邀请有礼
    @RequestMapping("/invitationCode")
    public String welfareMallJump(String openid, Model model) {
        TxVipUser userInfo = txVipUserService.getUserInfo(openid);
        if (userInfo == null) {
            return "invitationCode";
        }
        String invitationCode = userInfo.getInvitationCode();
        model.addAttribute("invitationCode", invitationCode);
        return "invitationCode";
    }
}
