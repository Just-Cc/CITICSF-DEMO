package com.citicsf.consumer.controller;

import com.citicsf.common.core.response.BaseResponse;
import com.citicsf.common.core.util.gson.GsonUtils;
import com.citicsf.consumer.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Cc
 * @Date: 2021/11/25 10:57
 */
@RestController
@RequestMapping("excel")
@Slf4j
public class UploadController {

    @Autowired
    private RestTemplate template;
    @Autowired
    private UploadService uploadService;

    @PostMapping("upload")
    public BaseResponse uploadExcel(@RequestParam("exchange") String exchange, @RequestParam("prodCode") String prodCode, @RequestParam("file") MultipartFile file) throws IOException {
        log.info("consumer request success");
        log.info("request Param [exchange:" + exchange + " prodCode:" + prodCode + "]");

        LinkedMultiValueMap<String, Object> postParams = new LinkedMultiValueMap<>();
        ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }

            @Override
            public long contentLength() {
                return file.getSize();
            }
        };
        //Resource resource = new InputStreamResource();

        postParams.add("file", byteArrayResource);
        postParams.add("exchange", exchange);
        postParams.add("prodCode", prodCode);
//        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity httpEntity = new HttpEntity(postParams, headers);
        String reqUrl = "http://localhost:8082/test/upload";
        log.info("reqUrl: " + reqUrl);
        String response = template.postForObject(reqUrl, httpEntity, String.class);
        log.info("request result: " + response);
        BaseResponse parseObject = GsonUtils.fromJson(response, BaseResponse.class);

        return parseObject;
    }

    @PostMapping("uploads")
    public BaseResponse uploadsExcel(@RequestParam("data") String json, @RequestParam("files") MultipartFile[] files) throws IOException {
        /*LinkedMultiValueMap<String, Object> postParams = new LinkedMultiValueMap<>();
        if (files.length > 0) {
            for (MultipartFile file : files) {
                ByteArrayResource byteArrayResource = new ByteArrayResource(file.getBytes()) {
                    @Override
                    public String getFilename() {
                        return file.getOriginalFilename();
                    }

                    @Override
                    public long contentLength() {
                        return file.getSize();
                    }
                };
                postParams.add("files", byteArrayResource);
            }
        } else {
            log.info("files");
        }
//        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity httpEntity = new HttpEntity(postParams, headers);
        String reqUrl = "http://localhost:8081/test/uploads";
        String response = template.postForObject(reqUrl, httpEntity, String.class);
        log.info(response);
        return BaseResponse.ok();*/
        return uploadService.upload(json, files);
    }

}
