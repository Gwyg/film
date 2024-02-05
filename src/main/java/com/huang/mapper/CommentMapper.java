package com.huang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: CommentMapper
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  17:21
 * @Version 1.0
 */
@Mapper
public interface CommentMapper {
    /**
     * 根据用户名查找影评
     * @param username
     * @return
     */
    @Select("select comment from comment where username = #{username}")
    List<String> getCommentByUsername(String username);
}
