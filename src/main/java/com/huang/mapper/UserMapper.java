package com.huang.mapper;

import com.huang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName: UserMapper
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  13:42
 * @Version 1.0
 */
@Mapper
public interface UserMapper {


    /**
     * 根据用户名和密码查询用户
     * @param user
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User getByUsernameAndPassword(User user);

    /**
     * 插入用户数据
     * @param user
     * @return
     */
    @Insert("insert into user values(null,#{username},#{password},#{name},#{gender},#{image})")
    int insertAll(User user);

    /**
     * 根据用户名查询用户
     * @param user
     * @return
     */
    @Select("select * from user where username = #{username}")
    User getByUsername(User user);

    /**
     * 根据用户名更改头像
     * @param username
     * @param url
     */
    @Update("update user set image = #{url} where username = #{username}")
    void updateImageByUsername(String username, String url);


    /**
     * 根据用户名查询自我介绍
     * @param username
     * @return
     */
    @Select("select self_introduction from user where username = #{username}")
    String getSelfIntroductionByUsername(String username);
}
