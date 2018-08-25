package com.tianxuan.makeup.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: Cookie工具类
 * <p>
 * 作者: luohongquan
 * 日期: 2018/5/3 0003 17:27
 */
public class CookieUtil {

    /**
     * 设置Cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**  
     * @description 获取Cookie
     * @author luohongquan
     * @date 2018/5/3 23:16
     * @return javax.servlet.http.Cookie
     */
    public static Cookie get(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**  
     * @description 遍历Cookie，转化为Map
     * @author luohongquan
     * @date 2018/5/3 
     * @param
     * @return java.util.Map<java.lang.String,javax.servlet.http.Cookie>
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();

        // 获取cookie数组，相比redis麻烦一些
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
