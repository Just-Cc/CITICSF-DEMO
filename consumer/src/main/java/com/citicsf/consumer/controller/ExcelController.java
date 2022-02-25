package com.citicsf.consumer.controller;

import com.citicsf.common.core.response.BaseResponse;
import com.citicsf.common.core.util.DateUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * @Author: Cc
 * @Date: 2021/11/26 9:58
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @PostMapping("download")
    public BaseResponse downloadExcel(HttpServletResponse response){
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + DateUtil.date2String(new Date(), DateUtil.PATTERN1[3]) + ".xlsx");

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        try(OutputStream out = response.getOutputStream()) {

        }catch (Exception e){
            System.out.println("失败");

        }
        return null;
    }
}
