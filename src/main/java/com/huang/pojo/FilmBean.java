package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: FilmBean
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:36
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmBean {

    private Float score;//评分
    private String photo;//剧照
    private String synopsis;//剧情简介
    private List<String> credits;//演职员

}
