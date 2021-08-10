package com.example.utils.service.impl;

import com.citicsf.common.core.response.BaseResponse;
import com.citicsf.common.core.util.gson.GsonUtils;
import com.example.utils.service.ExcelUploadService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cc
 * @Date: 2021/6/24 15:38
 */
public class ExcelUploadServiceImpl implements ExcelUploadService {
    /*@Override
    public BaseResponse uploadExcel(MultipartFile file, String prodCode) {
        BaseResponse<String> result = new BaseResponse<>();
        ApplyExcelDTO applyExcelDTO = new ApplyExcelDTO();
        //校验文件大小
        boolean sizeFlag = checkFileSize(file.getSize(), 100, "M");
        if(!sizeFlag){
            return BaseResponse.of("","超出文件大小");
        }

        //获取上传文件的名称
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toUpperCase();
        //校验文件后缀名
        if(!ExcelConstant.EXCEL_XLSX.equals(suffix)){
            return BaseResponse.of(ResponseEnum.ERROR_FILE_TYPE);
        }

        InputStream ins = null;
        try {
            //获取文件输入流
            ins = file.getInputStream();
            //转换成WorkBook 这里使用WorkBookFactory的方法，兼容xlsx和xls文件，但目前只使用XLSX
            Workbook wb = WorkbookFactory.create(ins);
            //校验模板
            Sheet sheet = wb.getSheetAt(0);
            if(!checkTemplate(sheet)){
                return BaseResponse.of(ResponseEnum.ERROR_FILE_TEMPLATE);
            }
            //解析文件
            List list = parseFile(sheet);
            applyExcelDTO.setExcelDTO(list);
            result = BaseResponse.ok(applyExcelDTO);
            ins.close();
        } catch (Exception e) {
            log.error("解析Excel失败",e);
            result = BaseResponse.fail();
        } finally {
            if(null!=ins){
                try {
                    ins.close();
                } catch (IOException e) {
                    log.error("关闭输入流失败！",e);
                }
            }
        }
        return result;
    }

    *//**
     *
     * @param len 文件长度
     * @param size 限制大小
     * @param unit 限制单位（B,K,M,G）
     * @return
     *//*
    public boolean checkFileSize(Long len, int size, String unit) {
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }

    *//**
     * 上期所Excel解析
     *//*
    public BaseResponse parse(Workbook wb,String prodCode){
        ApplyExcelDTO applyExcelDTO = new ApplyExcelDTO();
        //每行的数据集合
        ArrayList<ExcelDTO> list = new ArrayList<>();
        InputStream ins = null;
        Sheet sheet = null;
        try {
            if(null!=wb){
                //SheetNumber
                //取第一个Sheet
                sheet = wb.getSheetAt(0);
            }else {
                return BaseResponse.of(ResponseEnum.ERROR_FILE_TEMPLATE);
            }
            //模板校验
            boolean flag = checkTemplate(sheet);
            if(!flag){
                return BaseResponse.of(ResponseEnum.ERROR_FILE_TEMPLATE);
            }
            //开始读取文件
            log.info("开始解析仓单注销Excel文件，总行数为："+sheet.getLastRowNum());
            //循环行,从文件头开始，跳过模板第一行
            this.parseFile(sheet,list);
            //存放每行数据
            applyExcelDTO.setExcelDTO(list);
        } catch (Exception e) {
            log.error("解析仓单注销Excel失败！",e);
            BaseResponse.fail();
        }
        log.info(GsonUtils.toJsonString(applyExcelDTO));
        return BaseResponse.ok(applyExcelDTO);
    }

    public boolean checkTemplate(Sheet sheet){
        boolean flag = true;
        if(!(null!=sheet.getRow(0).getCell(0) && "仓单号".equals(sheet.getRow(0).getCell(0).toString()))){
            flag = false;
        }

        if(!(null!=sheet.getRow(0).getCell(1) && "注销数量(张)".equals(sheet.getRow(0).getCell(1).toString()))){
            flag = false;
        }
        return flag;
    }

    public List parseFile(Sheet sheet){
        ArrayList<Object> list = new ArrayList<>();
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++){
            ExcelDTO apply = new ExcelDTO();
            for(int j=0;j<2;j++){
                //循环每行设置类型，否则单元格内如果是数字则会报错
                sheet.getRow(rowNum).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
            }
            //仓单号
            if(isCellEmpty(sheet.getRow(rowNum).getCell(0))){
                apply.setReceiptNumber(sheet.getRow(rowNum).getCell(0).getStringCellValue());
            }
            //转让数量(张)
            if(isCellEmpty(sheet.getRow(rowNum).getCell(1))){
                apply.setTransferNum(sheet.getRow(rowNum).getCell(1).getStringCellValue());
            }
            //如果全为空则不存
            if(StringUtils.isBlank(apply.getReceiptNumber()) &&StringUtils.isBlank(apply.getTransferNum())){

            }else{
                list.add(apply);
            }
        }
        return list;
    }*/
}
