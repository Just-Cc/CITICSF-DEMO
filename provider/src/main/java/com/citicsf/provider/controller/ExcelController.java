package com.citicsf.provider.controller;

import com.citicsf.common.core.response.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cc
 * @Date: 2021/11/26 9:56
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @PostMapping("download")
    public BaseResponse downloadExcel(){


        return null;
    }
}
