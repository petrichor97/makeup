package com.tianxuan.makeup.handler;

import com.tianxuan.makeup.config.ProjectUrlConfig;
import com.tianxuan.makeup.excpetion.SellerAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-21 10:37
 **/
@ControllerAdvice
public class SellExceptionHandler {
    //拦截登录异常
    @Autowired
    ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler( value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/index"));
    }
}
