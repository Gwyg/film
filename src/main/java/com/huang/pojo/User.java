package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: User
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/30  16:59
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;//ID
    private String username;//用户名
    private String password;//密码
    private String name;//昵称
    private Short gender;//性别， 1 男 ，2 女
    private String image;//头像
    private String selfIntroduction;//自我介绍
}
