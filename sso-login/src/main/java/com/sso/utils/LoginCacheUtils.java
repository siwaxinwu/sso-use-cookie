package com.sso.utils;

import com.sso.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * description：
 * author：dingyawu
 * date：created in 12:10 2020/9/12
 * history:
 */
public class LoginCacheUtils {
    public static Map<String, User> userInfos = new HashMap<>(1000);

}
