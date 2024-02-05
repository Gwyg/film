package com.huang.service.impl;

import com.huang.mapper.CommentMapper;
import com.huang.mapper.RecordsMapper;
import com.huang.mapper.UserMapper;
import com.huang.pojo.Comment;
import com.huang.pojo.Records;
import com.huang.pojo.User;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/30  17:02
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordsMapper recordsMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public int regist(User user) {
        User u = userMapper.getByUsername(user);
        return u == null?userMapper.insertAll(user):0;
    }

    @Override
    public String upload(MultipartFile image) throws IOException {
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //构造唯一的文件名 -- uuid
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        String url = "D:\\javaproject\\film\\src\\main\\resources\\userimage\\" + newFileName;
        //将接收到的文件存储在服务器的磁盘当中
        image.transferTo(new File(url));
        return url;
    }

    @Override
    public void updateimage(String username, String url) {
        userMapper.updateImageByUsername(username,url);
    }

    @Override
    public Records records(String username) {
        //查询用户的想看
        List<String> pasts = recordsMapper.getPastByUsername(username);
        List<String> wants = recordsMapper.getWantByUsername(username);
        Records records = new Records(username, pasts, wants);
        return records;
    }

    @Override
    public Comment comment(String username) {
        List<String> comments = commentMapper.getCommentByUsername(username);
        Comment comment = new Comment(username,comments);
        return comment;
    }

    @Override
    public String selfIntroduction(String username) {
        String s = userMapper.getSelfIntroductionByUsername(username);
        return s;
    }
}
