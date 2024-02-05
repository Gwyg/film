package com.huang.controller;

import com.huang.pojo.Result;
import com.huang.pojo.User;
import com.huang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: RegistController
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  14:05
 * @Version 1.0
 */
@Slf4j
@RestController
public class RegistController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public Result regist(@RequestBody User user){
        log.info("用户注册：{}",user);
        int i = userService.regist(user);
        return i == 1?Result.success():Result.error("用户名已存在");
    }

}
