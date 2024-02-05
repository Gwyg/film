package com.huang.controller;

import com.huang.pojo.FilmBean;
import com.huang.pojo.Films;
import com.huang.pojo.PageBean;
import com.huang.pojo.Result;
import com.huang.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: FilmController
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:35
 * @Version 1.0
 */
@Slf4j
@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/film")
    public Result film(String filmName){
        log.info("查询{}电影详情",filmName);
        FilmBean f = filmService.film(filmName);
        return Result.success(f);
    }

    @GetMapping("/search")
    public Result searchFilm(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,String filmName){
        log.info("搜索电影");
        PageBean p = filmService.search(page,pageSize,filmName);
        return Result.success(p);
    }

}
