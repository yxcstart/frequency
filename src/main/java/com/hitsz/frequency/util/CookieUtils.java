package com.hitsz.frequency.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yang
 * @create 2021-03-21 10:21
 */
public class CookieUtils {

    public static String getValue(HttpServletRequest request,String key){
        if (request==null||key==null){
            throw new IllegalArgumentException("参数为空！");
        }
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                if (key.equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
