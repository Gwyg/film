package com.huang.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huang.mapper.CreditsMapper;
import com.huang.mapper.FilmMapper;
import com.huang.pojo.FilmBean;
import com.huang.pojo.Films;
import com.huang.pojo.PageBean;
import com.huang.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: FilmServiceImpl
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:42
 * @Version 1.0
 */
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private CreditsMapper creditsMapper;

    @Override
    public FilmBean film(String filmName) {
        Films films = filmMapper.getByFilmName(filmName);
        List<String> credits = creditsMapper.getCreditsByFilmName(filmName);
        FilmBean filmBean = new FilmBean(films.getScore(),films.getPhoto(),films.getSynopsis(),credits);
        return filmBean;
    }

    @Override
    public PageBean search(Integer page, Integer pageSize, String filmName) {
        PageHelper.startPage(page,pageSize);
        List<Films> list = filmMapper.getAll(filmName);
        Page<Films> p = (Page<Films>) list;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }


}
