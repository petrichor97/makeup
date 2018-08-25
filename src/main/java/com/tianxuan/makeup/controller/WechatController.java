package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.config.ProjectUrlConfig;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-16 16:40
 **/
@Controller
@Slf4j
@RequestMapping("/wechat")
public class WechatController {


    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 功能描述: 【买家端】微信授权
     * <p>
     * 日期: 2018/8/16 0003 15:12
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/wechat/userInfo";
        // String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        String redirectURL = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code，redirectURL={}", redirectURL);
        return "redirect:" + redirectURL;

    }


    /**
     * 功能描述: 【买家端】获取openId
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/3 0003 15:12
     */
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        log.info("【微信网页授权】code={}", code);
        log.info("【微信网页授权】state={}", returnUrl);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("【微信网页授权】openId={}", openId);
        return "redirect:" + returnUrl + "?openid=" + openId;
    }


    @GetMapping("/menu/create")
    public String menuCreateSample() throws WxErrorException {
        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setName("美妆中心");
        button1.setType(WxConsts.MenuButtonType.VIEW);
        button1.setUrl("http://petrichor.natapp1.cc/sell/activityJump");

        WxMenuButton button2 = new WxMenuButton();
        button2.setName("会员中心");

        WxMenuButton button21 = new WxMenuButton();
        button21.setType(WxConsts.MenuButtonType.VIEW);
        button21.setName("注册");
        button21.setUrl(projectUrlConfig.getWechatMpAuthorize()+"/sell/wechat/authorize?returnUrl=/userRegisterJump");

        WxMenuButton button22 = new WxMenuButton();
        button22.setType(WxConsts.MenuButtonType.VIEW);
        button22.setName("我的会员");
        button22.setUrl(projectUrlConfig.getWechatMpAuthorize()+"/sell/wechat/authorize?returnUrl=/vipCard");

        WxMenuButton button23 = new WxMenuButton();
        button23.setType(WxConsts.MenuButtonType.VIEW);
        button23.setName("在线氪金");
        button23.setUrl(projectUrlConfig.getWechatMpAuthorize()+"/sell/wechat/authorize?returnUrl=/myWallet");

        WxMenuButton button24 = new WxMenuButton();
        button24.setType(WxConsts.MenuButtonType.VIEW);
        button24.setName("积分商城");
        button24.setUrl(projectUrlConfig.getWechatMpAuthorize()+"/sell/wechat/authorize?returnUrl=/integralShop");


        button2.getSubButtons().add(button21);
        button2.getSubButtons().add(button22);
        button2.getSubButtons().add(button23);
        button2.getSubButtons().add(button24);


        WxMenuButton button3 = new WxMenuButton();
        button3.setName("福利中心");

//    WxMenuButton button31 = new WxMenuButton();
//    button31.setType(WxConsts.MenuButtonType.VIEW);
//    button31.setName("特惠秒杀");
//    button31.setUrl("http://www.soso.com/");

        WxMenuButton button32 = new WxMenuButton();
        button32.setType(WxConsts.MenuButtonType.VIEW);
        button32.setName("当季活动");
        button32.setUrl("http://petrichor.natapp1.cc/sell/activityJump");

        WxMenuButton button33 = new WxMenuButton();
        button33.setType(WxConsts.MenuButtonType.VIEW);
        button33.setName("福利商城");
        button33.setUrl("http://petrichor.natapp1.cc/sell/wechat/authorize?returnUrl=/welfareMall");

        WxMenuButton button34 = new WxMenuButton();
        button34.setType(WxConsts.MenuButtonType.VIEW);
        button34.setName("邀请有礼");
        button34.setUrl("http://petrichor.natapp1.cc/sell/wechat/authorize?returnUrl=/invitationCode");

//    button3.getSubButtons().add(button31);
        button3.getSubButtons().add(button32);
        button3.getSubButtons().add(button33);
        button3.getSubButtons().add(button34);

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);

        return wxMpService.getMenuService().menuCreate(menu);
    }






}
