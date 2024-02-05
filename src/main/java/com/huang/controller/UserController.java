package com.huang.controller;

import com.huang.pojo.Comment;
import com.huang.pojo.Records;
import com.huang.pojo.Result;
import com.huang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/30  17:01
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/personal")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/records")
    public Result records(String username){
        log.info("{}的想看/看过",username);
        Records records = userService.records(username);
        return Result.success(records);
    }

    @PostMapping("/comment")
    public Result comment(String username){
        log.info("{}的影评",username);
        Comment comment = userService.comment(username);
        return Result.success(comment);
    }

    @GetMapping
    public Result selfIntroduction(String username){
        String s = userService.selfIntroduction(username);
        return Result.success(s);
    }
}
