package com.huang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: RecordsMapper
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:03
 * @Version 1.0
 */
@Mapper
public interface RecordsMapper {
    /**
     * 根据用户名查询看过
     * @param username
     * @return
     */
    @Select("select past from records where username = #{username}")
    List<String> getPastByUsername(String username);

    /**
     * 根据用户名查询想看
     * @param username
     * @return
     */
    @Select("select want from records where username = #{username}")
    List<String> getWantByUsername(String username);
}
