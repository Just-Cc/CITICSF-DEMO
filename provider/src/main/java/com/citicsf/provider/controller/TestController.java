package com.citicsf.provider.controller;

import com.citicsf.common.core.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Cc
 * @Date: 2021/11/25 11:02
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @PostMapping("upload")
    public BaseResponse uploadExcel(@RequestParam("exchange") String exchange, @RequestParam("prodCode") String prodCode, @RequestParam("file") MultipartFile file) {

        log.info("rest request success");
        log.info("request Param [exchange:" + exchange + " prodCode:" + prodCode);
        log.info("file size : " + file.getSize());
        return BaseResponse.ok();
    }

    @PostMapping("uploads")
    public BaseResponse uploadsExcel(@RequestParam("json") String json, @RequestParam("files") MultipartFile[] files) throws IOException {
        log.info("request Param [json:" + json + "]");
        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                log.info("正在处理第" + i + "个文件，文件大小：" + files[i].getSize());
            }
        }
        return BaseResponse.ok();
    }
}
