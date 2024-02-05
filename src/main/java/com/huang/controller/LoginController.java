package com.huang.controller;

import com.huang.pojo.Result;
import com.huang.pojo.User;
import com.huang.service.UserService;
import com.huang.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  13:37
 * @Version 1.0
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录:{}",user);
        User u = userService.login(user);
        //登录成功，生成令牌，并下发令牌
        if(u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", u.getUsername());
            claims.put("name", u.getName());
            String jwt = JwtUtils.generateJWT(claims);//jwt 中包含了当前登录的员工信息
            return Result.success(jwt);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }

}
