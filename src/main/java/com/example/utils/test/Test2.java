package com.example.utils.test;

import com.citicsf.common.minio.MinioException;
import com.citicsf.common.minio.MinioTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cc
 * @Date: 2021/8/11 16:11
 */
@RestController
@RequestMapping("testt")
public class Test2 {
    @Autowired
    private MinioTemplate minioTemplate;

    String bucket = "obs-attachments";

    @GetMapping("ggg")
    public void ggg() throws MinioException {
        String path = minioTemplate.getPresignedObjectUrl(bucket, "png", 60);
        System.out.println(path);
    }


    @GetMapping("ttt")
    public void ttt() {


    }
}
