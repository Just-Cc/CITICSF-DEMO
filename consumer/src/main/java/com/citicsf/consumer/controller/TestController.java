package com.citicsf.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: Cc
 * @Date: 2021/11/29 20:16
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @PostMapping("uploads")
    public String test(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        if (files.length > 0) {
            log.info("file size : " + files.length);
            for (MultipartFile file : files) {
                log.info("file name : " + file.getOriginalFilename());
                sb.append("file").append(file.getOriginalFilename());
            }
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            log.info("url:{}, value: {}", key, request.getHeader(key));
        }

        return sb.toString();
    }
}
