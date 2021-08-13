package com.example.utils.service.impl;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: Cc
 * @Date: 2021/8/11 15:01
 */
@Service
public class ImageServiceImpl {

    private String IMAGE_PATH = "C:\\Users\\lenovo\\Desktop\\assets\\1526434145635.png";

    public String getImageBase64() throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();

        FileInputStream fin = new FileInputStream(IMAGE_PATH);
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        String base64 = encoder.encode(bytes);
        System.out.println(base64);
        return base64;
    }
}
