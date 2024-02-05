package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: Records
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  16:54
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Records {

    private String username;//用户名
    private List<String> past;//看过
    private List<String> want;//想看

}
