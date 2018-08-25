package com.tianxuan.makeup.controller;

import com.tianxuan.makeup.constant.CookieConstant;
import com.tianxuan.makeup.constant.RedisConstant;
import com.tianxuan.makeup.dataobject.SellerInfo;
import com.tianxuan.makeup.enums.ResultEnum;
import com.tianxuan.makeup.excpetion.SellException;
import com.tianxuan.makeup.service.impl.SellerServiceImpl;
import com.tianxuan.makeup.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-20 18:23
 **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("login/index");
    }

    /**
     * 登录方法
     * @param sellerId
     * @param password
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("sellerId") String sellerId,
                              @RequestParam("password") String password,
                              HttpServletResponse response){

        //1.账号密码和数据库中匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoBysellerId(sellerId);
        if (sellerInfo != null ) {

            if (password.equals(sellerInfo.getPassword())){
                //2.设置token至redis
                String token = UUID.randomUUID().toString();
                Integer expire = RedisConstant.EXPIRE;
                redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token), sellerId , expire , TimeUnit.SECONDS);
                //3.设置token至cookie
                CookieUtil.set(response, CookieConstant.TOKEN,token,CookieConstant.EXPIRE);

                return new ModelAndView("login/success");
            }else {
                return new ModelAndView("login/error");
            }
        }else {
           return new ModelAndView("login/error");
        }
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String, Object> map){

        //1.从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/index");
        return new ModelAndView("common/success",map);
    }
}
