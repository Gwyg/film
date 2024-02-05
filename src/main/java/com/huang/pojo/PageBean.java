package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageBean
 * Description:
 *      分页查询结果的封装类
 * @Author 小黄
 * @Create 2024/1/30  13:46
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Long total;//总记录数
    private List rows;//数据列表

}
