package com.sso.controller;

import com.sso.LoginAPP;
import com.sso.pojo.User;
import com.sso.utils.LoginCacheUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description：
 * author：dingyawu
 * date：created in 9:58 2020/9/12
 * history:
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static  Set<User> USERS;
    static {
        USERS = new HashSet<>();
        USERS.add(new User(1, "roy", "123456"));
        USERS.add(new User(2, "tom", "123456789"));
        USERS.add(new User(2, "jack", "1234567890"));
    }

    @PostMapping
    public String doLogin(User user, HttpSession httpSession, HttpServletResponse response){
        String target = (String)httpSession.getAttribute("target");
        //模拟DB查找
        Optional<User> result = USERS.stream().filter((ele) -> {
            return user.getUsername().equals(ele.getUsername()) && user.getPassword().equals(ele.getPassword());
        }).findFirst();
        if (result.isPresent()){
            //保存用户
            String token = UUID.randomUUID().toString();
            LoginCacheUtils.userInfos.put(token, result.get());
            //重定向到target地址
            Cookie cookie = new Cookie("token", token);
            cookie.setDomain("codeshop.com");
            response.addCookie(cookie);
            return "redirect:" + target;
        }else {
            //登录失败
            httpSession.setAttribute("msg", "用户名和密码错误");
            return "login";
        }
    }

    @GetMapping("info")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(String token){
        if (StringUtils.isEmpty(token)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        User user = LoginCacheUtils.userInfos.get(token);
        return ResponseEntity.ok(user);
    }

}
