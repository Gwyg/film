package com.huang.controller;

import com.huang.pojo.Result;
import com.huang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName: UploadController
 * Description:
 *
 * @Author 小黄
 * @Create 2024/1/31  14:27
 * @Version 1.0
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private UserService userService;

    @PostMapping("/upload")
    public Result upload(String username,MultipartFile image) throws IOException {
        log.info("头像上传,文件名:{}",image.getOriginalFilename());
        String url = userService.upload(image);
        //更改数据库中image信息
        userService.updateimage(username,url);
        return Result.success(url);
    }

}
