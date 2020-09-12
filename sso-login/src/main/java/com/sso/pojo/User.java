package com.sso.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * description：
 * author：dingyawu
 * date：created in 9:55 2020/9/12
 * history:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//添加链式调用
public class User {
    private Integer id;
    private String username;
    private String password;
}
