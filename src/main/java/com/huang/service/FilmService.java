package com.huang.service;

import com.huang.pojo.FilmBean;
import com.huang.pojo.Films;
import com.huang.pojo.PageBean;

import java.util.List;

/**
 * ClassName: FilmService
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:41
 * @Version 1.0
 */
public interface FilmService {
    /**
     * 查询电影的详细信息
     * @param filmName
     * @return
     */
    FilmBean film(String filmName);

    /**
     * 查询电影信息
     * @param filmName
     * @return
     */
    PageBean search(Integer page, Integer pageSize, String filmName);
}
