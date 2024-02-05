package com.huang.mapper;

import com.huang.pojo.Films;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: FilmMapper
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:46
 * @Version 1.0
 */
@Mapper
public interface FilmMapper {

    /**
     * 根据电影名查询
     * @param filmName
     * @return
     */
    @Select("select * from films where film_name = #{filmName}")
    Films getByFilmName(String filmName);

    /**
     * 根据电影名查询电影
     * @param filmName
     * @return
     */
    @Select("select * from films where film_name like concat('%',#{filmName},'%')")
    List<Films> getAll(String filmName);
}
