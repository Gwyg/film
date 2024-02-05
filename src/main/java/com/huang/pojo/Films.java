package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Films
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  16:28
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Films {

    private Integer id;//ID
    private String filmName;//电影名
    private String filmFile;//电影文件
    private String photo;//剧照
    private Float score;//评分
    private String synopsis;//电影简介

}
