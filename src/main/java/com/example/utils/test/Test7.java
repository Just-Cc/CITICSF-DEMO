package com.example.utils.test;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: Cc
 * @Date: 2021/11/15 16:06
 */
public class Test7 {
    public static void main(String[] args) {
        HttpHeaders httpHeaders = new HttpHeaders();
        RestTemplate template = new RestTemplate();
        httpHeaders.set("a","b");
        String forObject = template.getForObject("1.2.3.4:8080", String.class, httpHeaders);
    }
}
