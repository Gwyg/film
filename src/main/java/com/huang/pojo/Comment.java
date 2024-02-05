package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: Comment
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:19
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String username;//用户名
    private List<String> comment;//我的影评

}
