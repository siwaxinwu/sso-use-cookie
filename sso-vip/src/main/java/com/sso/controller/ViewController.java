package com.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * description：
 * author：dingyawu
 * date：created in 10:26 2020/9/12
 * history:
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String USER_INFO_ADDRESS = "http://login.codeshop.com:9000/login/info?token=";
    @GetMapping("/index")
    public String toIndex(@CookieValue(required = false, value = "token") Cookie cookie, HttpSession httpSession){
        if (null != cookie){
            String token = cookie.getValue();
            if (!StringUtils.isEmpty(token)){
                Map result = restTemplate.getForObject(USER_INFO_ADDRESS + token, Map.class);
                httpSession.setAttribute("loginUser", result);
            }
        }
        return "index";
    }
}
