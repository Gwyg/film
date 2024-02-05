package com.huang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: CreditsMapper
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:51
 * @Version 1.0
 */
@Mapper
public interface CreditsMapper {
    /**
     * 根据电影名查询演职员
     * @param filmName
     * @return
     */
    @Select("select credits from credits where film_name = #{filmName}")
    List<String> getCreditsByFilmName(String filmName);
}
