package com.huang.service;

import com.huang.pojo.Comment;
import com.huang.pojo.Records;
import com.huang.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName: UserService
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/30  17:01
 * @Version 1.0
 */

public interface UserService {

    /**
     * 用户登录操作
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int regist(User user);

    /**
     * 用户上传头像
     * @param image
     * @return
     */
    String upload(MultipartFile image) throws IOException;

    /**
     * 更改数据库中的image地址
     * @param username
     * @param url
     */
    void updateimage(String username, String url);

    /**
     * 查询用户想看/看过
     * @param username
     * @return
     */
    Records records(String username);

    /**
     * 根据用户名查找我的影评
     * @param username
     * @return
     */
    Comment comment(String username);

    /**
     * 根据用户名查询自我介绍
     * @param username
     * @return
     */
    String selfIntroduction(String username);
}
