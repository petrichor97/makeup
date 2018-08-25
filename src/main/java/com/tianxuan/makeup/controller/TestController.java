package com.tianxuan.makeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-16 13:09
 **/

@Controller

public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

@ResponseBody
    @RequestMapping("/testFor")
    public String testFor(HttpServletRequest request) {
    Object test = request.getAttribute("test");
    String s = test.toString();
    return s;
    }

    @RequestMapping("/aaa")
    public String str() {
        return "test";
    }
}

