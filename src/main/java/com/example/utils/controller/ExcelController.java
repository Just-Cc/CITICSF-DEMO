package com.example.utils.controller;

import com.citicsf.common.core.response.BaseResponse;
import com.example.utils.service.ExcelUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Cc
 * @Date: 2021/6/24 15:36
 */
@RestController
public class ExcelController {

    /*@Autowired
    ExcelUploadService excelUploadService;

    public BaseResponse uploadExcel(@RequestParam("file") MultipartFile file, @RequestParam("prodCode")String prodCode){
        return excelUploadService.uploadExcel(file,prodCode);
    }

    public void downloadExcel(@RequestBody ApplyExcelDTO applyExcelDTO, HttpServletRequest request, HttpServletResponse response){
        excelDownloadService.download(applyExcelDTO,request,response);
    }*/
}
