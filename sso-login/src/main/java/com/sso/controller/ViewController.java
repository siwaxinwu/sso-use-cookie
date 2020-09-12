package com.sso.controller;

import com.sso.pojo.User;
import com.sso.utils.LoginCacheUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * description：页面跳转逻辑
 * author：dingyawu
 * date：created in 9:59 2020/9/12
 * history:
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String toLogin(@RequestParam(required = false, defaultValue = "") String target, HttpSession httpSession,
                          @CookieValue(value = "token",required = false) Cookie cookie){

        if (StringUtils.isEmpty(target)){
            target = "http://www.codeshop.com:9010";
        }
        //如果是已经登录的用户再次访问登录系统时，就要重定向
        if (null != cookie){
            String value = cookie.getValue();
            User user = LoginCacheUtils.userInfos.get(value);
            if (null != user){
                return "redirect" + target;
            }
        }
        //存储重定向地址，存储之前要校验地址的合法性
        httpSession.setAttribute("target", target);
        return "login";
    }
}
