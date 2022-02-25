package com.citicsf.consumer.service.impl;

import com.citicsf.common.core.response.BaseResponse;
import com.citicsf.consumer.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Cc
 * @Date: 2021/11/30 9:35
 */
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Autowired
    private RestTemplate template;

    @Override
    public BaseResponse upload(String json, MultipartFile[] files) throws IOException {
        LinkedMultiValueMap<String, Object> postParams = new LinkedMultiValueMap<>();
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
        postParams.add("data", json);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity httpEntity = new HttpEntity(postParams, headers);
        String reqUrl = "http://10.21.69.240:8002/core/v1/temporary";
//        String reqUrl = "http://localhost:8081/test/uploads";
        String response = template.postForObject(reqUrl, httpEntity, String.class);
        log.info(response);
        return BaseResponse.ok();
    }
}
