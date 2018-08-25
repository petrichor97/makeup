package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.pojo.UserWelfareIdAndWelfareName;
import com.tianxuan.makeup.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelfareController {

    @Autowired
    private WelfareService welfareService;

    //    根据userid获取福利列表
    @RequestMapping("/welfareMall")
    public String findWelfareNameByOpenid(String openid, Model model) {
        List<UserWelfareIdAndWelfareName> welfareNameList = welfareService.findWelfareByOpenid(openid);
//        if (welfareNameList.size() == 0) {
//            model.addAttribute("welfareNameList", null);
//        }
        model.addAttribute("welfareNameList", welfareNameList);
        model.addAttribute("openid", openid);
        return "welfareMall";

    }

    //    用户领取后删除福利
    @RequestMapping("/welfareDelect")
    public String delectWelfareByOpenid(String goods,int userWelfareId,Model model) {
        welfareService.delectWelfareByuserWelfareId(userWelfareId);
        model.addAttribute("goods", goods);
        return "countDown";

    }
}
