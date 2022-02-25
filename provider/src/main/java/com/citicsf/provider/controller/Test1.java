package com.citicsf.provider.controller;

import com.citicsf.common.core.response.BaseResponse;
import com.citicsf.common.core.util.gson.GsonUtils;
import com.citicsf.provider.entity.WarehouseAcceptCheckDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Cc
 * @Date: 2022/1/7 18:09
 */
@RestController
@RequestMapping("provider")
@Slf4j
public class Test1 {
    String instUrl = "http://10.21.69.240:8080";
    String localhost = "http://localhost:8002";
    String base = "/api/inst-online/core/v1";
    String noGatewayBase = "/core/v1";

    @PostMapping("postCopAcceptCheckUpdate")
    BaseResponse postCopTransferCheckUpdate(@RequestBody List<WarehouseAcceptCheckDTO> dto) throws IOException {
        log.info("request param: {}", GsonUtils.toJsonString(dto));
        //String reqUrl = instUrl + base + "/cop/accept/check/update";
        String reqUrl = localhost + noGatewayBase + "/cop/accept/check/update";
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String param = GsonUtils.toJsonString(dto);
        HttpEntity httpEntity = new HttpEntity(param, headers);
        String response = template.postForObject(reqUrl, httpEntity, String.class);
        log.info("response {}", response);
        BaseResponse baseResponse = GsonUtils.fromJson(response, BaseResponse.class);
        return baseResponse;
    }
}
